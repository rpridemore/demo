package com.vanderlande.demo;

import com.vanderlande.demo.message.BookAdded;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner(@Qualifier(value = "in") KafkaTemplate<String, BookAdded> template) {
        return args -> {
            System.out.println("Sending Bilbo on an adventure...");
            template.send("booktopic1", new BookAdded("J.R.R. Tolkien", "The Hobbit"));
        };
    }

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("topic1")
                .partitions(10)
                .replicas(1)
                .build();
    }

}
