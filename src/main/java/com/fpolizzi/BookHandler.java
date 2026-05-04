package com.fpolizzi;

import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import java.util.List;

/**
 * Created by fpolizzi on 04.05.26
 */
public class BookHandler {

    public ServerResponse getAllBooks(ServerRequest request) {

        return ServerResponse.ok()
                .body(
                        List.of(new BookRouteConfig.Book(
                                "Harry Potter",
                                "J. K. Rowling"))
                );
    }

}
