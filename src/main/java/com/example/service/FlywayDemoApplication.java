package com.example.service;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Author: Alisher Odilov
 * Date: 06.04.2023
 */

@SpringBootApplication
public class FlywayDemoApplication implements CommandLineRunner {
    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(FlywayDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Flyway.configure().baselineOnMigrate(true).dataSource(dataSource).load().migrate();
    }
}
//
//@Component
//public class CommandLineAppStartupRunner implements CommandLineRunner {
//
//    private final DataSource dataSource;
//
//    public CommandLineAppStartupRunner(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        Flyway.configure().baselineOnMigrate(true).dataSource(dataSource).load().migrate();
//    }
//}
