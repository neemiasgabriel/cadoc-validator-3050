package com.picpay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CadocValidator3050Application {
  public static void main(String[] args) {
    SpringApplication.run(CadocValidator3050Application.class, args);
  }
}
