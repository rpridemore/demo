package com.vanderlande.demo;

import com.vanderlande.demo.message.BookAdded;
import com.vanderlande.demo.message.BookAdditionConfirmed;
import com.vanderlande.demo.persist.Book;
import com.vanderlande.demo.persist.DemoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class DemoService {
    @Autowired
    @Qualifier(value = "out")
    private KafkaTemplate<String, BookAdditionConfirmed> template;
    @Autowired
    private DemoRepo repo;

    public DemoService() {
        System.out.println("DemoService initialized...");
    }

    @KafkaListener(id = "myId", topics = "booktopic1", autoStartup = "true")
    public void listen(BookAdded added) {
        System.out.println("Message received: " + added);
        Book persisted = repo.save(new Book(added.getAuthor(), added.getTitle()));
        System.out.println("ID: " + persisted.getId());
        template.send("booktopic2", new BookAdditionConfirmed(persisted.getId()));
    }
}
