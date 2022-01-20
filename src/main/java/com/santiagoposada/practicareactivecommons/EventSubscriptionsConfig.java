package com.santiagoposada.practicareactivecommons;


import lombok.RequiredArgsConstructor;
import org.reactivecommons.async.api.HandlerRegistry;
import org.reactivecommons.async.impl.config.annotations.EnableMessageListeners;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableMessageListeners
@RequiredArgsConstructor
public class EventSubscriptionsConfig {

    private final Controller controller;

    @Bean
    public HandlerRegistry eventSubscriptions(){
        return HandlerRegistry.register()
                .listenEvent("event.listener.queue", event -> controller.handler(event.getData()), MessageToBotmaker.class);
    }
}
