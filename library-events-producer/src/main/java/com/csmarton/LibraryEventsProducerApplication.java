package com.csmarton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryEventsProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryEventsProducerApplication.class, args);
	}

	/*@Bean
	MicrometerConsumerListener<Integer, String> consumerListener(MeterRegistry registry) {
		return new MicrometerConsumerListener<>(registry);
	}

	@Bean
	MicrometerProducerListener<Integer, String> producerListener(MeterRegistry registry) {
		return new MicrometerProducerListener<>(registry);
	}*/
}
