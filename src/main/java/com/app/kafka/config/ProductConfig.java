package com.app.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.app.core.ProductCreatedEvent;
import com.app.kafka.constants.ProductConstants;

@Configuration
public class ProductConfig {

	@Value("${spring.kafka.producer.bootstrap-servers}")
	public String bootStrapServers;
	@Value("${spring.kafka.producer.key-serializer}")
	private String keySerializer;
	@Value("${spring.kafka.producer.value-serializer}")
	private String valueSerializer;
	@Value("${spring.kafka.producer.acks}")
	private String acks;
	@Value("${spring.kafka.producer.properties.delivery.timeout.ms}")
	private String deliveryTimeOut;
	@Value("${spring.kafka.producer.properties.linger}")
	private String linger;
	@Value("${spring.kafka.producer.properties.request.timeout.ms}")
	private String requestTimeOut;
	
	@Autowired
	public Map<String,Object> producerConfigs(){
		
		Map<String,Object> config=new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServers);
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, keySerializer);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, valueSerializer);
		config.put(ProducerConfig.ACKS_CONFIG, acks);
		config.put(ProducerConfig.DELIVERY_TIMEOUT_MS_CONFIG,deliveryTimeOut);
		config.put(ProducerConfig.LINGER_MS_CONFIG, linger);
		config.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, requestTimeOut);
		return config;
	}
@Bean
	NewTopic createTopic() {

		return TopicBuilder.name(ProductConstants.TOPIC_NAME)
				.partitions(3)
				.replicas(3)
				.configs(Map.of("min.insync.replicas","2"))
				.build();
	}

@Bean
  ProducerFactory<String, ProductCreatedEvent> producerFactory(){ //ProducerFactory is used for send the results to Topic 
	 return new DefaultKafkaProducerFactory<>(producerConfigs()); // Defaultkafkaproducerfactory is used to read the kafka configuration values
 }

@Bean
KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate(){
	return new KafkaTemplate<String,ProductCreatedEvent>(producerFactory());
}


























}
