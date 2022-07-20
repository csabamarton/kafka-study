package com.csmarton.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.kafka.KafkaClientMetrics;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class KafkaMetricsProvider {
    private static final String TOPIC = "my-example-topic";


    public static void main(String[] args) throws Exception {
     /*   EphemeralKafkaBroker broker = EphemeralKafkaBroker.create();
        broker.start();
        KafkaHelper kafkaHelper = KafkaHelper.createFor(broker);

        KafkaConsumer<String, String> consumer = kafkaHelper.createStringConsumer();
        KafkaProducer<String, String> producer = kafkaHelper.createStringProducer();

        MeterRegistry registry = SampleConfig.myMonitoringSystem();
        new KafkaClientMetrics(consumer).bindTo(registry);
        new KafkaClientMetrics(producer).bindTo(registry);

        consumer.subscribe(singletonList(TOPIC));

        Flux.interval(Duration.ofMillis(10)).doOnEach(n -> producer.send(new ProducerRecord<>(TOPIC, "hello", "world")))
                .subscribe();

        for (;;) {
            consumer.poll(Duration.ofMillis(100));
            consumer.commitAsync();
        }*/
    }
}
