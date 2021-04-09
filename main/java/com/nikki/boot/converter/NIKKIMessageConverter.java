package com.nikki.boot.converter;

import com.nikki.boot.bean.Person;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

public class NIKKIMessageConverter implements HttpMessageConverter<Person> {
    //是否支持读@RequestBody注解传过来的值
    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return false;
    }
    //是否支持写
    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return clazz.isAssignableFrom(Person.class);
    }

    /**
     * 服务器要统计所有的MessageConverter都能处理那些类型的数据
     * application/x-NIKKI
     * @return
     */
    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return Collections.singletonList(new MediaType("application","x-NIKKI",StandardCharsets.UTF_8));
    }

    //自定义协议数据的读入
    @Override
    public Person read(Class<? extends Person> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    //自定义协议数据的写出
    @Override
    public void write(Person person, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        String data = person.getUserName() + ";" + person.getAge() + ";" + person.getBirth();
        //写出去（body:输出流）
        OutputStream body = outputMessage.getBody();
        body.write(data.getBytes(StandardCharsets.UTF_8));
//        body.flush();
//        body.close();
    }
}
