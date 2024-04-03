package com.vinit.design.javaStreams;

import com.vinit.design.problems.calendar.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PracticeJavaStream {

    static class UserObject {
        int key;
        int value;
        public UserObject(int _key, int _value) {
            this.value = _value;
            this.key = _key;
        }
        public int getKey() {
            return this.key;
        }
    }
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5,6,7,8));
        List<UserObject> userList = new ArrayList<>(Arrays.asList(
                new UserObject(1,1),
                new UserObject(2,2),
                new UserObject(3,3),
                new UserObject(4,4)
        )
        );
        // For each is the terminal operations
        userList
            .stream()
            .forEach(e -> System.out.println(e.key));

        // map - produces new streams after applying fun to each element
        numbers
                .stream()
                .map(num -> num * 10)
                .forEach(System.out::println);
        // Collect - common way to get stuff out of the stream
        List<Integer> newNumbers = numbers
                .stream()
                .map(num -> num * 10000)
                .toList();
        newNumbers.forEach(System.out::println);
        // filter -
        userList
                .stream()
                .map(e -> e.key * 100)
                .filter(e -> e != null)
                .forEach(System.out::println);
        // toArray - to convert to array
        // findFirst().orElse(null);
        // flatMap -
    }
}
