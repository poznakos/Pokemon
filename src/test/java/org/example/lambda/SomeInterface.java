package org.example.lambda;

public interface SomeInterface {

//    String field;

    String createString();

    int returnInt();

    default String methodWithBody(){
        return "";
    }

}
