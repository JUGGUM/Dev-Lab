package hello.springmvc.basic.domain.codeSandBox.controller;

import java.util.LinkedList;
import java.util.ListIterator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PracticeZoneController {

    public static void main(String[] args) {
        LinkedList<String> animals = new LinkedList<>();
        // add() method
        animals.add("dog");
        animals.add("cat");
        animals.addFirst("cow");
        animals.add("mouse");

        // set() method
        animals.set(0, "human");

        for (String animal : animals) {
            System.out.print(animal + "  ");
        }
        System.out.println();

        // using listIterator
        ListIterator<String> listIterator = animals.listIterator(animals.size());
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + "  ");
        }

        System.out.println(animals);
    }
}
