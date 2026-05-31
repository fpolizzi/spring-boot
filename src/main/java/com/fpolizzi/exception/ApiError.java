package com.fpolizzi.exception;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * Created by fpolizzi on 5/31/26
 */
public record ApiError(
        String path,
        String message,
        int statusCode,
        ZonedDateTime zonedDateTime,
        List<String> errors
) {
}
