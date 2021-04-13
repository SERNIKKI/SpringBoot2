package com.nikki.boot.config;

import com.nikki.boot.bean.Pet;
import com.nikki.boot.converter.NIKKIMessageConverter;
import com.nikki.boot.interceptor.LoginInterceptor;
import com.nikki.boot.servletApi.MyFilter;
import com.nikki.boot.servletApi.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration(proxyBeanMethods = false)
public class WebConfig{
    //自定义自己的_method，实现表单中的put和delete等功能被识别
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
        HiddenHttpMethodFilter methodFilter = new HiddenHttpMethodFilter();
        methodFilter.setMethodParam("_m");
        return methodFilter;
    }

    //自定义定制SpringMVC的配置，所有SpringMVC相关配置都在这里进行配置
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            //实现矩阵变量功能
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                //不移除;后面的内容,矩阵变量功能就可以实现
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }

            //添加自己的Converter（类型转换器）
            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(new Converter<String, Pet>() {
                    @Override
                    public Pet convert(String source) {
                        if(!source.isEmpty()){
                            Pet pet = new Pet();
                            String[] split = source.split(",");
                            pet.setName(split[0]);
                            pet.setAge(split[1]);
                            return pet;
                        }
                        return null;
                    }
                });
            }

            //扩展详细转换器实现返回定制的内容
            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                //添加自定义的MessageConverter
                converters.add(new NIKKIMessageConverter());
            }

            //配置内容协商功能，实现可以识别format后面的自定义类型
            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
                Map<String, MediaType> mediaTypes = new HashMap<>();
                mediaTypes.put("json",MediaType.APPLICATION_JSON);
                mediaTypes.put("xml",MediaType.APPLICATION_XML);
                mediaTypes.put("test",MediaType.TEXT_XML);
//                mediaTypes.put("gg",MediaType.parseMediaType("application/x-NIKKI"));
                mediaTypes.put("gg",new MediaType("application","x-NIKKI",StandardCharsets.UTF_8));
                ParameterContentNegotiationStrategy parameterStrategy = new ParameterContentNegotiationStrategy(mediaTypes);
                /*
                    1、Collections.singletonList(strArray)返回一个不可变的集合，该集合长度只有1，
                    可以减少内存空间。返回值为Collections的内部实现类，没有add方法。
                    调用add、set方法都会出错。
                    2、Arrays.asList(strArray)返回值是一个可变的集合，该集合默认长度为10，
                    返回值是其内部类，不具有add方法，可以通过set方法进行增加值。
                    3、优雅的将一个元素转换为一个集合:
                    List<K> list = Stream.of(k).collect(Collectors.toList());
                 */
                HeaderContentNegotiationStrategy contentNegotiationStrategy = new HeaderContentNegotiationStrategy();
                configurer.strategies(Arrays.asList(parameterStrategy,contentNegotiationStrategy));
            }
            //拦截器相关功能的配置
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginInterceptor())
                        //要拦截那些请求
                        .addPathPatterns("/**")
                        //要放行那些请求
                        .excludePathPatterns("/login","/css/**","/fonts/**","/images/**","js/**");
            }
        };
    }
//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        UrlPathHelper urlPathHelper = new UrlPathHelper();
//        //不移除;后面的内容,矩阵变量功能就可以实现
//        urlPathHelper.setRemoveSemicolonContent(false);
//        configurer.setUrlPathHelper(urlPathHelper);
//    }

}
