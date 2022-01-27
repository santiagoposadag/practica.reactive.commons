package com.santiagoposada.practicareactivecommons;


import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.reactivecommons.async.impl.communications.TopologyCreator;
import org.reactivecommons.async.impl.config.ConnectionFactoryProvider;
import org.reactivecommons.async.impl.config.RabbitProperties;
import org.reactivecommons.async.impl.config.props.BrokerConfigProps;
import org.reactivecommons.async.impl.converters.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.PropertyMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Mono;
import reactor.rabbitmq.*;
import reactor.util.retry.Retry;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.util.logging.Level;

@Configuration
public class Config {

    @Bean
    public Controller creatingController(ReactiveEventsGateway reactiveEventsGateway){
        return new Controller(reactiveEventsGateway);
    }
//    @Bean
//    public ConnectionFactoryProvider appConnectionFactory(RabbitProperties properties) throws KeyManagementException, NoSuchAlgorithmException {
//        final ConnectionFactory factory = new ConnectionFactory();
//        PropertyMapper map = PropertyMapper.get();
//        map.from(properties::determineHost).whenNonNull().to(factory::setHost);
//        map.from(properties::determinePort).to(factory::setPort);
//        map.from(properties::determineUsername).whenNonNull().to(factory::setUsername);
//        map.from(properties::determinePassword).whenNonNull().to(factory::setPassword);
//        map.from(properties::determineVirtualHost).whenNonNull().to(factory::setVirtualHost);
//        map.from(properties::getRequestedHeartbeat).whenNonNull().asInt(Duration::getSeconds).to(factory::setRequestedHeartbeat);
//        factory.setAutomaticRecoveryEnabled(true);
//        factory.setTopologyRecoveryEnabled(true);
//        return () -> factory;
//    }

}
