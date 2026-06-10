package com.fpolizzi.post;

/**
 * Created by fpolizzi on 6/9/26
 */
public record Post(
        Long id,
        Integer userId,
        String title,
        String body
) {
}
