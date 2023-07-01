package org.example.infrastructure.rest.usersbooks;

import com.google.gson.Gson;
import org.example.domain.UserWithBooksDetailed;
import org.example.infrastructure.rest.usersbooks.models.BookDetailedFromMicroservice;
import org.example.infrastructure.rest.usersbooks.models.UserWithBooksPreview;

import java.util.List;
import java.util.Optional;

public class UsersBooksServiceStream {

    private static final UserBooksApi restClient = UsersBooksApiRestClient.getUsersBooks();

    public UserWithBooksDetailed getUserBooks(int userId) {
        return Optional
                .of(getUserWithBookPreview(userId))
                .map(userWithBooksPreview -> createUserWithBooksDetailed(userWithBooksPreview))
                .get();
    }

    private UserWithBooksDetailed createUserWithBooksDetailed(UserWithBooksPreview userWithBooksPreview) {
        List<UserWithBooksDetailed.BookDetailed> booksDetailed = userWithBooksPreview.booksPreviewToBooksDetailed();

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

    public static BookDetailedFromMicroservice getBookDetails(int bookId) {
        String bookResponse = restClient.getBook(bookId);

        return new Gson().fromJson(bookResponse, BookDetailedFromMicroservice.class);
    }

}
