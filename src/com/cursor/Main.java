package com.cursor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        show();
    }

    private static void marks() {
        System.out.println("Text Mark");
        System.out.println("Input a number from 0 to 10");
        int n = scanner.nextInt();
        String mark = switch (n) {
            case 9, 10 -> "Well";
            case 7, 8 -> "Good";
            case 6 -> "Acceptance";
            case 5 -> "Bad";
            case 0,1,2,3,4 -> "Very bad";
            default -> "Wrong input";
        };
        System.out.println(mark);
    }

    private static void uniqueNumbers() {
        System.out.println("Unique Numbers");
        System.out.println("Enter number set: ");
        List<Integer> list = new ArrayList<>();
        String line = scanner.next();
        String[] stringArray = line.split(",");
        for (String s: stringArray) {
            list.add(Integer.parseInt(s));
        }
        var result = list
                .stream()
                .collect(Collectors.teeing(
                        Collectors.counting(),
                        Collectors.toSet(),
                        (n, set) -> ((double)set.size()/ n * 100) + "%"));
        System.out.println(result);
    }

    private static void show() {
        String s = "Start";
        while (!s.equalsIgnoreCase("q")) {
            System.out.println("Choose exercise [uniqueNumbers, marks] or type 'q' for exit:");
            s = scanner.nextLine();
            if (s.equalsIgnoreCase("uniqueNumbers")) {
                uniqueNumbers();
                s = "";
            }
            if (s.equalsIgnoreCase("marks")) {
                marks();
                s = "";
            }
        }

    }
}
