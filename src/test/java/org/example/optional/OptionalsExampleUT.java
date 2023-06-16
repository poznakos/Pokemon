package org.example.optional;

import org.example.infrastructure.rest.usersbooks.Users;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class OptionalsExampleUT {

    @Test
    public void someOptionals(){

        // Object object;
        Object object = null;

        // null safe
        if(object != null){
            object.toString();
        }


        Optional<Users> usersOptionalEmpty = Optional.empty();
        Optional<Users> usersOptional = Optional.ofNullable(null);

        usersOptional
                .map( users -> users.toString() )
                .map( userString -> userString.toLowerCase() )
                .filter( userStringLowerCase -> userStringLowerCase.length() < 3 )
                .orElse("To jest null");
    }

}
