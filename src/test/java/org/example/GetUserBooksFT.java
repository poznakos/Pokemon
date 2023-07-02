package org.example;

import com.github.tomakehurst.wiremock.WireMockServer;
import lombok.SneakyThrows;
import org.example.infrastructure.rest.WireMockRunner;
import org.example.infrastructure.rest.usersbooks.UserBooksApiMock;
import org.example.infrastructure.rest.usersbooks.models.BookDetailedFromMicroservice;
import org.example.infrastructure.rest.usersbooks.models.UserWithBooksPreview;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.example.infrastructure.rest.Jackson.JSON_MAPPER;
import static org.example.interfaces.CliInterface.CLI_QUESTION;

@Tag("FT")
public class GetUserBooksFT {

    @Test
    public void runAppButOnMocks() {
    // GIVEN
        // - Wiremock setup
        WireMockServer wireMockServer = new WireMockRunner().get();
        users(wireMockServer, 0);
        books(wireMockServer, 0);
        books(wireMockServer, 1);
        books(wireMockServer, 2);
        books(wireMockServer, 3);
        books(wireMockServer, 4);
        wireMockServer.start();

//        String wiremockUrl = "http://localhost:"+wireMockServer.getOptions().portNumber();
//        UserBooksApi usersBooksWireMock = UsersBooksApiRestClient.getUsersBooks(wiremockUrl);

        // - CLI - real communication through CLI - INPUT
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("0\n".getBytes()));

        // - CLI - OUTPUT
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

    // WHEN
        Main.main(new String[0]);

    // THEN
        System.setIn(stdin);
        System.setOut(stdout);
        String outputText = byteArrayOutputStream.toString();
        String key = CLI_QUESTION;
        String output = outputText.substring(outputText.indexOf(key) + key.length()).trim();

        // - Assertions
        output.toString();
    }

    @SneakyThrows
    private static void users(WireMockServer wireMockServer, int id) {
        String user = new UserBooksApiMock().getUser(id);
        wireMockServer.stubFor(
                get(
                        urlEqualTo("/users/" + id)
                ).willReturn(
                        aResponse().withJsonBody(
                                JSON_MAPPER.valueToTree(JSON_MAPPER.readValue(user, UserWithBooksPreview.class))
                        )
                )
        );
    }

    @SneakyThrows
    private static void books(WireMockServer wireMockServer, int id) {
        String book = new UserBooksApiMock().getBook(id);
        wireMockServer.stubFor(
                get(
                        urlEqualTo("/books/" + id)
                ).willReturn(
                        aResponse().withJsonBody(
                                JSON_MAPPER.valueToTree(JSON_MAPPER.readValue(book, BookDetailedFromMicroservice.class))
                        )
                )
        );
    }

}
