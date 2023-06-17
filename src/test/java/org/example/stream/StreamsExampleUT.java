package org.example.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExampleUT {

    @Test
    public void streamsExample() {
        Integer[] intArray = new Integer[3];
        intArray[0] = 0;
        intArray[1] = null;
        intArray[2] = 2;

//        List<String> arrayList = new ArrayList<>();
//
//        for (int i = 0; i < intArray.length; i++) {
//            String intArrayString = intArray[i].toString();
//            arrayList.add(intArrayString);
//        }
//
//        arrayList.toString();

        /* Stream example */

//        new ArrayList<>().stream();
//        new HashSet<>().stream();
//        Stream.of(new Users(),new Users());

        Set<String> set = Arrays.stream(intArray)
//                .parallel()
                .filter(Objects::nonNull)
                .filter(obj -> Objects.nonNull(obj))
//                .mapToObj( i -> String.valueOf(i))
                .map(i -> i.toString())
                .collect(Collectors.toSet());

    }



}
