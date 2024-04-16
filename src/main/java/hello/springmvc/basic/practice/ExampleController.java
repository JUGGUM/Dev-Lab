package hello.springmvc.basic.practice;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/example")
public class ExampleController {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("apple", "banana", "orange");
        list.forEach(System.out::println);

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");
        // 문자열 길이가 5 이상인 이름만 필터링
        List<String> longNames = names.stream()
                .filter(name -> name.length() >= 5)
                .toList();
        System.out.println("Long names: " + longNames); // ["Alice", "Charlie", "David"]

        // 대문자로 변환
        List<String> uppercaseNames = names.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println("Uppercase names: " + uppercaseNames); // ["ALICE", "BOB", "CHARLIE", "DAVID", "EVE"]

        // 이름 길이의 합계 계산
        int totalLength = names.stream()
                .mapToInt(String::length)
                .sum();
        System.out.println("Total length of names: " + totalLength); // 20

        // for 문 스트림이용
        int[] numberArray = {8,7,1,557,12};
        for(int number : numberArray){
            System.out.println(number);
        }

        enum Day {
            MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
        }

        // java 14부터 사용하는 간결과 switch
        Day day = Day.MONDAY;
        int value = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY                -> 7;
            case THURSDAY, SATURDAY     -> 8;
            case WEDNESDAY              -> 9;
            default                     -> throw new IllegalStateException("Invalid day: " + day);
        };
    }
}