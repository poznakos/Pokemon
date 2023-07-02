package org.example.infrastructure.rest.usersbooks;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.example.domain.UserWithBooksDetailed;
import org.example.infrastructure.rest.usersbooks.models.BookDetailedFromMicroservice;
import org.example.infrastructure.rest.usersbooks.models.UserWithBooksPreview;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class UsersBooksServiceTraditional {

    private final UserBooksApi restClient;

    public UserWithBooksDetailed getUserBooks(int userId) {
        // Pobranie użytkownika
        UserWithBooksPreview userWithBooksPreview = getUserWithBookPreview(userId);

        // Pobranie od użytkownika uproszczonej listy książek
        List<UserWithBooksPreview.BookPreview> booksPreview = userWithBooksPreview.getBookPreview();

        // Przygotowanie listy dla ksiązek z szczegółami
        List<UserWithBooksDetailed.BookDetailed> booksDetailed = new ArrayList<>();

        // Pętla z zapytaniami o szczegóły książek na podstawie id z uproszczonej listy książek
        for (UserWithBooksPreview.BookPreview bookPreview : booksPreview) {
            Integer bookId = bookPreview.getId();
            BookDetailedFromMicroservice bookDetails = getBookDetails(bookId);

            UserWithBooksDetailed.BookDetailed bookDetailed = UserWithBooksDetailed.BookDetailed.builder()
                    .id(bookDetails.getId())
                    .title(bookDetails.getTitle())
                    .author(bookDetails.getAuthor())
                    .genre(bookDetails.getGenre())
                    .publisher(bookDetails.getPublisher())
                    .build();

            booksDetailed.add(bookDetailed);
        }

        // Tworzymy nasz docelowy obiekt, który posiada użytkownika i szczegóły książek - UserWithBooksDetailed
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

    private BookDetailedFromMicroservice getBookDetails(int bookId) {
        String bookResponse = restClient.getBook(bookId);

        return new Gson().fromJson(bookResponse, BookDetailedFromMicroservice.class);
    }

}
