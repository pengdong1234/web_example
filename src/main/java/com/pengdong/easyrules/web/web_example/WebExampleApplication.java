package com.pengdong.easyrules.web.web_example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class WebExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebExampleApplication.class, args);
    }

}
