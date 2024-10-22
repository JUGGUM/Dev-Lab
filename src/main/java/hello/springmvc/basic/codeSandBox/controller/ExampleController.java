package hello.springmvc.basic.codeSandBox.controller;


import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/example")
@RequiredArgsConstructor
public class ExampleController {

    public static void main(String[] args) {

        List<String> list2 = Arrays.asList("apple", "banana", "orange");
        list2.forEach(System.out::println);

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

        // 문자열 길이가 5 이상인 이름만 필터링
        List<String> longNames = names.stream()
                .filter(name -> name.length() >= 5) // 조건에 맞는 요소만을 선택하여 스트림으로 반환
                .toList();
        System.out.println("Long names: " + longNames); // ["Alice", "Charlie", "David"]

        // 대문자로 변환
        List<String> uppercaseNames = names.stream().map(String::toUpperCase).toList();
        System.out.println("Uppercase names: "
                + uppercaseNames); // ["ALICE", "BOB", "CHARLIE", "DAVID", "EVE"]

        // 새로운 스트림 병합
        Stream<List<Integer>> stream3 = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4));
        Stream<Integer> flatMappedStream = stream3.flatMap(list -> list.stream());
        System.out.println("flatMap : " + flatMappedStream);

        // 중복된 요소를 제건한 stream
        Stream<String> stream2 = Stream.of("apple", "banana", "apple", "cherry");
        Stream<String> distinctStream = stream2.distinct();
        System.out.println("distinctStream : " + distinctStream);

        // 이름 길이의 합계 계산
        int totalLength = names.stream().mapToInt(String::length).sum();
        System.out.println("Total length of names: " + totalLength); // 20

        // for 문 스트림이용
        int[] numberArray = {8, 7, 1, 557, 12};
        for (int number : numberArray) {
            System.out.println(number);
        }

        enum Day {
            MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
        }

        // java 14부터 사용하는 간결과 switch
        Day day = Day.MONDAY;
        int value = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY -> 7;
            case THURSDAY, SATURDAY -> 8;
            case WEDNESDAY -> 9;
            default -> throw new IllegalStateException("Invalid day: " + day);
        };

        // Map테스트
        Map<Integer, Integer> values = new HashMap<>();
        values.put(1, 10);
        values.put(2, 20);
        values.put(3, 30);
        values.put(4, 40);
        values.put(5, 50);
        values.put(6, 60);

        for (Map.Entry<Integer, Integer> entry : values.entrySet()) {
            System.out.println("MAP : " + entry.getKey() + "========" + entry.getValue());
        }

        //QUEUE 테스트
        Queue<Integer> queue = new LinkedList<>();
        // offer을 사용하여 요소를 추가함
        // 실패 시 return type이 false라서 add()보다는 offer()을 사용하는 것이 좋음
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        // 삭제 시 앞에 있는 요소를 삭제함 -> [2, 3]
        queue.remove();
        // 특정 요소 삭제 -> [3]
        queue.remove(2);

        // 큐에 포함된 요소가 있는지 확인 -> true
        System.out.println(queue.contains(3));

        // head에 위치한 값을 출력 -> 3
        System.out.println(queue.peek());

        // 큐의 크기 출력 -> 1
        System.out.println(queue.size());

        // 큐의 요소 비우기 -> []
        queue.clear();

        // 큐가 비었는지 확인 -> true
        System.out.println(queue.isEmpty()); // true

        // STACK 테스트
        Stack<Integer> stack = new Stack<>();
        stack.add(3);
        stack.add(4);
        stack.add(5);
        stack.pop();

        // 스택 top에있는 원소반환
        stack.peek();
        stack.size();
        stack.isEmpty();
    }
}