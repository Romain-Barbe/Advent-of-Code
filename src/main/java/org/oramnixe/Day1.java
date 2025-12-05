package org.oramnixe;

import java.io.IOException;
import java.util.ArrayList;

public class Day1 {
    private final ArrayList<String> inputFileContent;

    public Day1(ArrayList<String> inputFileContent) {
        this.inputFileContent = inputFileContent;
    }

    static void main() throws IOException {
        int dayNumber = 1;
        System.out.println("DAY " + dayNumber + " TEST :");
        Day1 test1 = new Day1(Utils.readInputFile("inputs/day" + dayNumber + "/day" + dayNumber + "Test.txt"));
        test1.solvePart1();
        test1.solvePart2();
        System.out.println("--------------------------------------------------");
        System.out.println("DAY " + dayNumber + " REAL DATA :");
        Day1 realData = new Day1(Utils.readInputFile("inputs/day" + dayNumber + "/day" + dayNumber + ".txt"));
        realData.solvePart1();
        realData.solvePart2();
        System.out.println("--------------------------------------------------");
    }

    public static class Dial {
        Integer position;

        public Dial(Integer position) {
            this.position = position;
        }

        // This method return the number of times the dial passed the 0 number
        public Integer rotate(String direction, Integer numberOfRotations) {
            Integer numberOfTimesPassedOnTheZero = 0;
            for (int i = 0; i < numberOfRotations; i++) {
                if (direction.equals("R")) {
                    this.position++;
                    if (this.position == 100) {
                        this.position = 0;
                    }
                } else {
                    this.position--;
                    if (this.position == -1) {
                        this.position = 99;
                    }
                }

                if (this.position == 0) {
                    //IO.println("position passed to 0");
                    numberOfTimesPassedOnTheZero++;
                }
            }
            //IO.println("new position = " + position);
            return numberOfTimesPassedOnTheZero;
        }
    }

    private void solvePart1() {
        IO.println(inputFileContent);

        int position = 50; // The dial is always pointing at 50 at the start
        int password = 0; // Number of times the dial stops at 0 after a rotation

        for (int i = 0; i <= inputFileContent.size() - 1; i++) {
            var direction = inputFileContent.get(i).charAt(0);
            int numberOfRotation = Integer.parseInt(inputFileContent.get(i).substring(1));

            //IO.println("Direction = " + direction + " and number of rotations = " + numberOfRotation);
            if (direction == 'R') {
                position += numberOfRotation;
                while (position >= 100) {
                    position -= 100;
                }
            } else {
                position -= numberOfRotation;
                while (position < 0) {
                    position += 100;
                }
            }

            //IO.println("new position = " + position);
            if (position == 0) password++;
        }

        IO.println("Part 1 result : " + password);
    }

    private void solvePart2() {
        IO.println(inputFileContent);

        var startingPosition = 50;
        int password = 0; // Number of times the dial passed at 0 during the rotation

        Dial dial = new Dial(startingPosition);

        for (int i = 0; i <= inputFileContent.size() - 1; i++) {
            var direction = inputFileContent.get(i).charAt(0);
            int numberOfRotation = Integer.parseInt(inputFileContent.get(i).substring(1));

            //IO.println("Direction = " + direction + " and number of rotations = " + numberOfRotation);

            password += dial.rotate(String.valueOf(direction), numberOfRotation);
        }

        IO.println("Part 2 result : " + password);
    }
}
