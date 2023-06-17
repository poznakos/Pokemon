package org.example.infrastructure.rest.usersbooks;

import com.google.gson.Gson;
import org.example.domain.UserWithBooksDetailed;
import org.example.infrastructure.rest.usersbooks.models.BookDetailedFromMicroservice;
import org.example.infrastructure.rest.usersbooks.models.UserWithBooksPreview;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UsersBooksServiceStream {

    private final UserBooksApi restClient = UsersBooksApiRestClient.getUsersBooks();

    public UserWithBooksDetailed getUserBooks(int userId) {
        return Optional
                .of(getUserWithBookPreview(userId))
                .map(userWithBooksPreview -> {
                    List<UserWithBooksDetailed.BookDetailed> booksDetailed = userWithBooksPreview.getBookPreview()
                            .stream()
                            .parallel()
                            .map(UserWithBooksPreview.BookPreview::getId)
                            .map(id -> getBookDetails(id))
                            .map(bookDetails -> UserWithBooksDetailed.BookDetailed.builder()
                                    .id(bookDetails.getId())
                                    .title(bookDetails.getTitle())
                                    .author(bookDetails.getAuthor())
                                    .genre(bookDetails.getGenre())
                                    .publisher(bookDetails.getPublisher())
                                    .build())
                            .collect(Collectors.toList());

                    return UserWithBooksDetailed.builder()
                            .id(userWithBooksPreview.getId())
                            .name(userWithBooksPreview.getName())
                            .surname(userWithBooksPreview.getSurname())
                            .booksDetailed(booksDetailed)
                            .build();
                })
                .get();
    }

    private UserWithBooksPreview getUserWithBookPreview(int userId) {
        String userResponse = restClient.getUser(userId);

        return new Gson().fromJson(userResponse, UserWithBooksPreview.class);
    }

    private BookDetailedFromMicroservice getBookDetails(int bookId) {
        String bookResponse = restClient.getBook(bookId);

        return new Gson().fromJson(bookResponse, BookDetailedFromMicroservice.class);
    }

}
