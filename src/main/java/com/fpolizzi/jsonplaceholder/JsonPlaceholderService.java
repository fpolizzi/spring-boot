package com.fpolizzi.jsonplaceholder;

import com.fpolizzi.post.Post;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;

/**
 * Created by fpolizzi on 6/9/26
 */
public interface JsonPlaceholderService {

    @GetExchange("/posts")
    List<Post> getAllPosts();

    @GetExchange("posts/{id}")
    Post getPostById(@PathVariable("id") Long id);

    @PostExchange("posts")
    void createPost(@RequestBody Post post);

    @DeleteExchange("posts/{id}")
    void deletePostById(@PathVariable("id") Long id);

    @PutExchange("posts/{id}")
    void updatePost(@PathVariable("id") Long id, @RequestBody Post post);
}