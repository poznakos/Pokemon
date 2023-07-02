package org.example.infrastructure.rest.usersbooks.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
public class UserWithBooksPreview {
    private String id;
    private String name;
    private String surname;
    @JsonProperty("books") @SerializedName("books") private List<BookPreview> bookPreview;

    @Getter
    public static class BookPreview {
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
