package com.luxoft.training.spring.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.bus.SpringCloudBusClient;
import org.springframework.cloud.bus.event.RemoteApplicationEvent;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class RemoteEventPublisher {
    @Autowired
    private SpringCloudBusClient busClient;

    public void publishEvent(RemoteApplicationEvent event) {
        busClient.springCloudBusOutput().send(MessageBuilder.withPayload(event).build());
    }
}
