package org.example.infrastructure.rest.usersbooks;

import com.google.gson.Gson;
import org.example.domain.UserWithBooksDetailed;
import org.example.infrastructure.rest.usersbooks.models.BookDetailedFromMicroservice;
import org.example.infrastructure.rest.usersbooks.models.UserWithBooksPreview;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UsersBooksServiceStreamOptimized {

    private final UserBooksApi restClient = UsersBooksApiRestClient.getUsersBooks();

    public UserWithBooksDetailed getUserBooks(int userId) {
        return Optional.of(getUserWithBookPreview(userId))
                .map(userWithBooksPreview -> createUserWithBooksDetails(userWithBooksPreview))
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

    private UserWithBooksDetailed createUserWithBooksDetails(UserWithBooksPreview userWithBooksPreview) {
        List<UserWithBooksPreview.BookPreview> bookPreview = userWithBooksPreview.getBookPreview();
        List<UserWithBooksDetailed.BookDetailed> booksDetailed = this.getBooksDetails(bookPreview);
        return buildUserWithBooksDetailed(userWithBooksPreview, booksDetailed);
    }

    List<UserWithBooksDetailed.BookDetailed> getBooksDetails(List<UserWithBooksPreview.BookPreview> booksPreviews) {
        return booksPreviews.stream()
                .parallel()
                .map(UserWithBooksPreview.BookPreview::getId)
                .map(id -> getBookDetails(id))
                .map(BookDetailedFromMicroservice::toBookDetailed)
                .collect(Collectors.toList());
    }

    private static UserWithBooksDetailed buildUserWithBooksDetailed(UserWithBooksPreview userWithBooksPreview, List<UserWithBooksDetailed.BookDetailed> booksDetailed) {
        return UserWithBooksDetailed.builder()
                .id(userWithBooksPreview.getId())
                .name(userWithBooksPreview.getName())
                .surname(userWithBooksPreview.getSurname())
                .booksDetailed(booksDetailed)
                .build();
    }

}
