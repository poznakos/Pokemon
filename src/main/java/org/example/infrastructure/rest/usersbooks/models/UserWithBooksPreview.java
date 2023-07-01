package org.example.infrastructure.rest.usersbooks.models;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import org.example.domain.UserWithBooksDetailed;

import java.util.List;
import java.util.stream.Collectors;

import static org.example.infrastructure.rest.usersbooks.UsersBooksServiceStream.getBookDetails;

@Getter
public class UserWithBooksPreview {
    private String id;
    private String name;
    private String surname;
    @SerializedName("books") private List<BookPreview> bookPreview;

    public List<UserWithBooksDetailed.BookDetailed> booksPreviewToBooksDetailed(){
        return this.getBookPreview()
                .stream()
                .parallel() // [ BookPreview, BookPreview, BookPreview, BookPreview, ... ]
                .map(bookPreview -> bookPreview.getId())// [ id, id, id, id, ... ]
                .map(id -> getBookDetails(id)) // [ BookDetailed, BookDetailed, BookDetailed, BookDetailed,... ]
                .map(bookDetails -> UserWithBooksDetailed.BookDetailed.builder()
                        .id(bookDetails.getId())
                        .title(bookDetails.getTitle())
                        .author(bookDetails.getAuthor())
                        .genre(bookDetails.getGenre())
                        .publisher(bookDetails.getPublisher())
                        .build())
                .collect(Collectors.toList());
    }

    @Getter
    public class BookPreview {
        private Integer id;
        private String title;
    }

}

/*
    public String method1(){
        return method1("asd");
    }

    public String method1(String text){
        return text;
    }
 */
