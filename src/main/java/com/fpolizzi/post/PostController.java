package com.fpolizzi.post;

import com.fpolizzi.jsonplaceholder.JsonPlaceholderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by fpolizzi on 6/9/26
 */
@RestController
@RequestMapping("api/v1/posts")
public class PostController {
    private final JsonPlaceholderService jsonPlaceholderService;

    public PostController(JsonPlaceholderService jsonPlaceholderService) {
        this.jsonPlaceholderService = jsonPlaceholderService;
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return jsonPlaceholderService.getAllPosts();
    }

    @GetMapping("{id}")
    public Post getPostById(@PathVariable("id") Long id) {
        return jsonPlaceholderService.getPostById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody Post post) {
        jsonPlaceholderService.createPost(post);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePostById(@PathVariable("id") Long id) {
        jsonPlaceholderService.deletePostById(id);
    }

    @PutMapping("{id}")
    public void updatePost(@PathVariable("id") Long id,
                           @RequestBody Post post) {
        jsonPlaceholderService.updatePost(id, post);
    }


}
