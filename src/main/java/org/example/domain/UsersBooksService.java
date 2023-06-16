package org.example.domain;

public class UsersBooksService {

    public UserBooks getUserBooks(int userId){
        return new UserBooks();
    }

    private class UserBooks {
    }
}
