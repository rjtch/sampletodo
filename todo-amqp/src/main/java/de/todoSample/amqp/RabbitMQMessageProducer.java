package de.todoSample.amqp;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class RabbitMQMessageProducer {
    private final AmqpTemplate amqpTemplate;

    public void publish(Object payload, String exchange, String routinKey) {
        amqpTemplate.convertAndSend(exchange, routinKey, payload);
        log.info("Publishing to {} using routingKey {} Payload {} ", exchange, routinKey, payload);
    }
}
