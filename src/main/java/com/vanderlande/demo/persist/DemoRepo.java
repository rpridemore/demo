package com.vanderlande.demo.persist;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DemoRepo extends CrudRepository<Book, Long> {

  List<Book> findByAuthor(String author);
  List<Book> findByTitle(String title);

  Book findById(long id);
}
