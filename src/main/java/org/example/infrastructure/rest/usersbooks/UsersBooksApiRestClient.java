package org.example.infrastructure.rest.usersbooks;

import feign.Feign;
import feign.codec.StringDecoder;

public class UsersBooksApiRestClient {

    public static UserBooksApi getUsersBooks(){
        return Feign.builder()
//                .decoder(new GsonDecoder())
                .decoder(new StringDecoder())
                .target(UserBooksApi.class, "http://localhost:8089");
    }

}
