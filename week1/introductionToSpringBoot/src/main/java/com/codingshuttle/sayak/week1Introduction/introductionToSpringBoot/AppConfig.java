package com.codingshuttle.sayak.week1Introduction.introductionToSpringBoot;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration   // Create our own beans
public class AppConfig {

    @Bean
    // @Scope("prototype")  // to change the scope of the bean:  {DEFAULT - Singleton} -> "prototype"
    Apple getApple() {   // Factory Method
        return new Apple();
    }
}
