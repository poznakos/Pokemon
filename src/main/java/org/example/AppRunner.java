package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.domain.UserWithBooksDetailed;
import org.example.infrastructure.rest.usersbooks.UserBooksApi;
import org.example.infrastructure.rest.usersbooks.UsersBooksServiceStreamOptimized;
import org.example.infrastructure.rest.usersbooks.UsersBooksServiceTraditional;
import org.example.interfaces.AppInterface;

public class AppRunner implements Runner {

    private final UsersBooksServiceTraditional usersBooksServiceTraditional = new UsersBooksServiceTraditional();
    private final UsersBooksServiceStreamOptimized usersBooksServiceStreamOptimized;

    public AppRunner(UserBooksApi userBooksApi) {
        this.usersBooksServiceStreamOptimized = new UsersBooksServiceStreamOptimized(userBooksApi);
    }

    @Override
    public void run(AppInterface appInterface) {
        Integer id = Integer.valueOf(appInterface.getInput());

//        UserWithBooksDetailed userBooksTraditional = usersBooksServiceTraditional.getUserBooks(id);
        UserWithBooksDetailed userBooksStream = usersBooksServiceStreamOptimized.getUserBooks(id);

        String result = new GsonBuilder().setPrettyPrinting().create().toJson(userBooksStream);
        appInterface.setResult(id, result);

        System.out.println(result);
    }
}