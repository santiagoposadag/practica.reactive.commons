package com.santiagoposada.practicareactivecommons;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Controller creatingController(ReactiveEventsGateway reactiveEventsGateway){
        return new Controller(reactiveEventsGateway);
    }
}
