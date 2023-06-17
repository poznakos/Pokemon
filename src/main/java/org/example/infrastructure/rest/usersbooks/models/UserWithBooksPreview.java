package org.example.infrastructure.rest.usersbooks.models;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;

@Getter
public
class UserWithBooksPreview {
    private String id;
    private String name;
    private String surname;

    @SerializedName("books")
    private List<BookPreview> bookPreview;

    @Getter
    public class BookPreview {
        private Integer id;
        private String title;
    }
}
