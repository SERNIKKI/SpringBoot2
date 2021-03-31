package com.nikki.boot.bean;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 只有在容器中的组件，才会拥有SpringBoot提供的功能
 */
@Data//生成getter和setter方法
@ToString//重写toString
@AllArgsConstructor//使用所有参数构建构造有参构造器
@NoArgsConstructor//无参构造器
@EqualsAndHashCode//重写equalsHashCode()方法
@Component //将类加入到容器中
@ConfigurationProperties(prefix = "mycar")
public class Car {
    private String name;
    private int price;

}
