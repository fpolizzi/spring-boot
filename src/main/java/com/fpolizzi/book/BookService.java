package com.fpolizzi.book;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fpolizzi on 07.05.26
 */
@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {

        return bookRepository.getAllBooks();
    }
}
