package org.example.infrastructure.rest.usersbooks;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.example.domain.UserWithBooksDetailed;
import org.example.infrastructure.rest.usersbooks.models.BookDetailedFromMicroservice;
import org.example.infrastructure.rest.usersbooks.models.UserWithBooksPreview;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class UsersBooksServiceStream {

    private final UserBooksApi restClient;

    public UserWithBooksDetailed getUserBooks(int userId) {
        return Optional
                .of(getUserWithBookPreview(userId))
                .map(userWithBooksPreview -> createUserWithBooksDetailed(userWithBooksPreview))
                .get();
    }

    private UserWithBooksDetailed createUserWithBooksDetailed(UserWithBooksPreview userWithBooksPreview) {
        List<UserWithBooksDetailed.BookDetailed> booksDetailed = this.booksPreviewToBooksDetailed(userWithBooksPreview);

        return UserWithBooksDetailed.builder()
                .id(userWithBooksPreview.getId())
                .name(userWithBooksPreview.getName())
                .surname(userWithBooksPreview.getSurname())
                .booksDetailed(booksDetailed)
                .build();
    }

    private UserWithBooksPreview getUserWithBookPreview(int userId) {
        String userResponse = restClient.getUser(userId);

        return new Gson().fromJson(userResponse, UserWithBooksPreview.class);
    }

    public List<UserWithBooksDetailed.BookDetailed> booksPreviewToBooksDetailed(UserWithBooksPreview userWithBooksPreview){
        return userWithBooksPreview.getBookPreview()
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

    public BookDetailedFromMicroservice getBookDetails(int bookId) {
        String bookResponse = restClient.getBook(bookId);

        return new Gson().fromJson(bookResponse, BookDetailedFromMicroservice.class);
    }

}
