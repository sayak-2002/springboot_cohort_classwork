package com.codingshuttle.sayak.week1Introduction.introductionToSpringBoot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {

    // @Autowired    // ------> Field Injection
    private final DB db;

    public DBService(DB db) {   // Constructor Injection      // Better ot use for code security

        this.db = db;
    }

    String getData() {

        // db = new DevDB(); // cannot be changed as DB is final
        return db.getData();
    }
}
