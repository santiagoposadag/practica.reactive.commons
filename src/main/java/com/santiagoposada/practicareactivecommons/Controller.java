package com.santiagoposada.practicareactivecommons;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class Controller {

    private final ReactiveEventsGateway reactiveEventsGateway;

    public Mono<Void> handler(MessageToBotmaker messageToBotmaker){

        System.out.println(messageToBotmaker.toString());
        reactiveEventsGateway.emit(messageToBotmaker);
        return Mono.empty();
    }
}
