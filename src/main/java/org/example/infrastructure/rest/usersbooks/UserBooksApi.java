package org.example.infrastructure.rest.usersbooks;

import feign.Param;
import feign.RequestLine;

public interface UserBooksApi {

    @RequestLine("GET /users/{userId}")
    String getUser(@Param("userId") int userId);

    @RequestLine("GET /books/{bookId}")
    String getBook(@Param("bookId") int bookId);

}
