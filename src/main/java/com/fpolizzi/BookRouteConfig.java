package com.fpolizzi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

/**
 * Created by fpolizzi on 04.05.26
 */
@Configuration
public class BookRouteConfig {

    record Book(
            String name,
            String author) {
    }

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {

        BookHandler bookHandler = new BookHandler();

        return RouterFunctions.route()
                .GET("/api/v1/books", bookHandler::getAllBooks)
                .build();
    }
}