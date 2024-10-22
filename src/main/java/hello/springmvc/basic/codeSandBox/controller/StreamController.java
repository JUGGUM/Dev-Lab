package hello.springmvc.basic.codeSandBox.controller;

import java.util.ArrayList;
import java.util.List;

public class StreamController {

    public static void main(String[] args) {
        System.out.println("dkdkd");
        StreamController streamController = new StreamController();
        double test = streamController.computeAverageOfNumbers(new ArrayList<>());
    }

    public double computeAverageOfNumbers(List<Integer> list) {
        return list.stream() // Stream<Integer>
                .mapToDouble(d -> d) // DoubleStream
                .average() // OptionalDouble
                .orElse(0.0); // double
    }
}
