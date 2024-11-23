package com.codingshuttle.sayak.week1Introduction.introductionToSpringBoot;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Apple {

    void eatApple() {

        System.out.println("I am eating the apple.");
    }

    @PostConstruct    // this annotation will be call the method after the bean is created
    void callThisBeforeAppleIsUsed() {

        System.out.println("Creating the apple before use.");
    }

    @PreDestroy       // this annotation will be call the method after the bean is destroyed
    void callThisBeforeDestroy() {

        System.out.println("Destroying the apple bean before destroy.");
    }
}
