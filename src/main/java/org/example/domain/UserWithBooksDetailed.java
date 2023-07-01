package org.example.domain;

import lombok.Builder;
import org.example.infrastructure.rest.usersbooks.models.UserWithBooksPreview;

import java.util.List;

@Builder
public class UserWithBooksDetailed {
    private String id;
    private String name;
    private String surname;
    private List<BookDetailed> booksDetailed;

    @Builder
    public static class BookDetailed{
        private Integer id;
        private String title;
        private String author;
        private String genre;
        private String publisher;
    }
}
