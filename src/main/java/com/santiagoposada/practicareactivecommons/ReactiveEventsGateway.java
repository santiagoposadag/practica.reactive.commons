package com.santiagoposada.practicareactivecommons;


import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.reactivecommons.api.domain.DomainEvent;
import org.reactivecommons.api.domain.DomainEventBus;
import org.reactivecommons.async.impl.config.annotations.EnableDomainEventBus;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.logging.Level;

import static reactor.core.publisher.Mono.from;

@Log
@Component
@EnableDomainEventBus
@RequiredArgsConstructor
public class ReactiveEventsGateway {
    private final DomainEventBus domainEventBus;

    public Mono<Void> emit(MessageToBotmaker event) {
        log.log(Level.INFO, "Emitiendo evento de dominio: {0}: {1}", new String[]{"event.publisher.queue", event.toString()});
        return from(domainEventBus.emit(new DomainEvent<>("event.publisher.queue", UUID.randomUUID().toString(), event)));
    }
}
