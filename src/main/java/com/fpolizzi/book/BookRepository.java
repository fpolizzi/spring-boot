package com.fpolizzi.book;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fpolizzi on 07.05.26
 */
@Repository
public class BookRepository {

    public List<Book> getAllBooks() {

        return List.of(
                new Book("Book 1"),
                new Book("Book 2"),
                new Book("Book 3"),
                new Book("Book 4"),
                new Book("Book 5"));
    }
}
