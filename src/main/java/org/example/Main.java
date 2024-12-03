package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        day1();

    }

    public static void day1(){
        int sumOfDifferences = 0;
        int similarityScore = 0;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        try {
            File input = new File("C:\\Users\\Darcy\\IdeaProjects\\adventofcode\\src\\main\\java\\org\\example\\adventofcodeday1input.txt");
            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] numbers = line.split("\\s+");
                if (numbers.length == 2) {
                    list1.add(Integer.parseInt(numbers[0]));
                    list2.add(Integer.parseInt(numbers[1]));
                } else {
                    System.err.println("Invalid line format: " + line);
                }

            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error: Input file not found.");

        }
        Collections.sort(list1);
        Collections.sort(list2);
        for (int i = 0; i < list1.size(); i++) {
            int firstItem = list1.get(i);
            int secondItem = list2.get(i);
            int diff = Math.abs(firstItem - secondItem);
            sumOfDifferences +=diff;

        }
        for (int item : list1){
            int countIn2 = Collections.frequency(list2,item);
            similarityScore += (item * countIn2);
        }
        System.out.println("sum of differences: " + sumOfDifferences);
        System.out.println("similarity score: "+ similarityScore);



    }

}