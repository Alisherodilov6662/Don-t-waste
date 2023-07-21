package com.example.service;

import org.flywaydb.core.Flyway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Author: Alisher Odilov
 * Date: 21.07.2023
 */
@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
    private DataSource dataSource;

    public CommandLineAppStartupRunner(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void run(String... args) throws Exception {
        Flyway.configure().baselineOnMigrate(true).dataSource(dataSource).load().migrate();
    }
}
