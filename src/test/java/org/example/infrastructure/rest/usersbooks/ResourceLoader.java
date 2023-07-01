package org.example.infrastructure.rest.usersbooks;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ResourceLoader {

    @SneakyThrows
    public static byte[] getResourceAsBytes(String resource){
        String resourceAbsolutePath = ResourceLoader.class.getClassLoader().getResource(resource).getPath();
        Path filePath = Paths.get(resourceAbsolutePath);
        return Files.readAllBytes(filePath);
    }

    public static String getResourceAsString(String resource){
        return new String(getResourceAsBytes(resource));
    }

}
