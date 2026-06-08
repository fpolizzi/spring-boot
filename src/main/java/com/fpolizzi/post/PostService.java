package com.fpolizzi.post;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

/**
 * Created by fpolizzi on 6/9/26
 */
@Service
public class PostService {
    private final RestClient restClient;

    public PostService() {
        this.restClient = RestClient.create(
                "https://jsonplaceholder.typicode.com"
        );
    }

    public List<Post> getAllPosts() {
        return restClient.get().uri("/posts")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }
}
