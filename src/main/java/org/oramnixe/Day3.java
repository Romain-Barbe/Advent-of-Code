package org.oramnixe;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

public class Day3 {
    static void main() throws IOException {
        int dayNumber = 3;
        ArrayList<String> testInputFileContent = Utils.readInputFile("inputs/day" + dayNumber + "/day" + dayNumber + "Test.txt");
        //ArrayList<String> realDataInputFileContent = Utils.readInputFile("inputs/day" + dayNumber + "/day" + dayNumber + ".txt");

        System.out.println("DAY " + dayNumber + " TEST :");
        solvePart1(testInputFileContent);
        //solvePart2(testInputFileContent);
        System.out.println("--------------------------------------------------");
        System.out.println("DAY " + dayNumber + " REAL DATA :");
        //solvePart1(realDataInputFileContent);
        //solvePart2(realDataInputFileContent);
        System.out.println("--------------------------------------------------");
    }

    private static void solvePart1(ArrayList<String> inputFileContent) {
        IO.println(inputFileContent);

        BigInteger solution = BigInteger.ZERO;

        for (String line : inputFileContent) {
            IO.println(line);

            int greaterNumber = 0;
            int greaterNumberPosition = 0;
            int secondGreaterNumber = 0;
            int secondGreaterNumberPosition = 0;

            var test = line.split("");
            for (var test2 : test) {
                IO.println(test2);
            }

            for (int i = line.length() - 1; i > 0; i--) {
                Integer actualNumber = Integer.valueOf(line.charAt(i));
                IO.println("\tactual number = " + actualNumber);
                if (actualNumber > greaterNumber) {
                    IO.println("\t\tle plus grand");
                    secondGreaterNumber = greaterNumber;
                    secondGreaterNumberPosition = greaterNumberPosition;
                    greaterNumber = actualNumber;
                    greaterNumberPosition = i;
                } else if (actualNumber > secondGreaterNumber) {
                    IO.println("\t\tle second plus grand");
                    secondGreaterNumber = actualNumber;
                    secondGreaterNumberPosition = i;
                }

                IO.println("\tgreaterNumber: " + greaterNumber);
                IO.println("\tsecondGreaterNumber: " + secondGreaterNumber);
            }
        }



        IO.println("Part 1 result : " + solution);
    }

    private static boolean isInvalid(BigInteger id) {
        String idString = id.toString();

        String idStringLeftPart = idString.substring(0, idString.length() / 2);
        String idStringRightPart = idString.substring(idString.length() / 2);

        return idStringLeftPart.equals(idStringRightPart);
    }
}
