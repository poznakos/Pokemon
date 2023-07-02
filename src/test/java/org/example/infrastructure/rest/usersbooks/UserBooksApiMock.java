package org.example.infrastructure.rest.usersbooks;

import java.util.List;

public class UserBooksApiMock implements UserBooksApi {

    private Integer user;
    private List<Integer> books;

    public UserBooksApiMock setUserId(int userId) {
        this.user = userId;
        return this;
    }

    public UserBooksApiMock setBookId(int bookId) {
        books.add(bookId);
        return this;
    }

    @Override
    public String getUser(int userId) {
        return ResourceLoader.getResourceAsString("stubs/users-0_200.json");
    }

    @Override
    public String getBook(int bookId) {
        return ResourceLoader.getResourceAsString("stubs/books-" + bookId + "_200.json");
    }


}
