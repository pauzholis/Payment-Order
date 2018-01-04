package ru.penza.learnjava.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Mihail on 26.12.2017.
 */
@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
