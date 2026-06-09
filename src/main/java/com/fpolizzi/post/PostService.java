package com.fpolizzi.post;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
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

    public Post getPostById(Long id) {
        return restClient.get().uri("/posts/{id}", id)
                .retrieve()
                .body(Post.class);
    }

    public void createPost(Post post) {
        restClient.post()
                .contentType(MediaType.APPLICATION_JSON)
                .body(post)
                .retrieve()
                .toBodilessEntity();
    }

    public void updatePost(Post post) {
        restClient.put()
                .contentType(MediaType.APPLICATION_JSON)
                .body(post)
                .retrieve()
                .toBodilessEntity();
    }

    public void deletePost(Long id) {
        restClient.delete()
                .uri("/posts/{id}", id)
                .retrieve()
                .toBodilessEntity();
    }
}
