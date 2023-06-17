package org.example.infrastructure.rest.usersbooks.models;

import lombok.Getter;
import org.example.domain.UserWithBooksDetailed;

@Getter
public class BookDetailedFromMicroservice {

    private Integer id;
    private String title;
    private String author;
    private String genre;
    private String publisher;

    public static UserWithBooksDetailed.BookDetailed toBookDetailed(BookDetailedFromMicroservice bookDetails) {
        return UserWithBooksDetailed.BookDetailed.builder()
                .id(bookDetails.getId())
                .title(bookDetails.getTitle())
                .author(bookDetails.getAuthor())
                .genre(bookDetails.getGenre())
                .publisher(bookDetails.getPublisher())
                .build();
    }

}
