package org.example.infrastructure.rest.usersbooks;

import feign.Feign;
import feign.codec.StringDecoder;

public class UsersBooksApiRestClient {

    public static UserBooksApi getUsersBooks(String usersBooksUrl){
        return Feign.builder()
//                .decoder(new GsonDecoder())
                .decoder(new StringDecoder())
                .target(UserBooksApi.class, usersBooksUrl);
    }

}
