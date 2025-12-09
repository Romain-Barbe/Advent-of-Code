package org.oramnixe;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

public class Day3 {
    static void main() throws IOException {
        int dayNumber = 3;
        ArrayList<String> testInputFileContent = Utils.readInputFile("inputs/day" + dayNumber + "/day" + dayNumber + "Test.txt");
        ArrayList<String> realDataInputFileContent = Utils.readInputFile("inputs/day" + dayNumber + "/day" + dayNumber + ".txt");

        System.out.println("DAY " + dayNumber + " TEST :");
        solvePart1(testInputFileContent);
        //solvePart2(testInputFileContent);
        System.out.println("--------------------------------------------------");
        System.out.println("DAY " + dayNumber + " REAL DATA :");
        solvePart1(realDataInputFileContent);
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

            var lineSplitted = line.split("");

            int i = 0;
            for (String actualNumberString : lineSplitted) {
                int actualNumber = Integer.parseInt(actualNumberString);
                //IO.println("\tactual number = " + actualNumber);
                if (actualNumber > greaterNumber) {
                    //IO.println("\t\tle plus grand");
                    if(lineSplitted.length > (i + 1)){
                        secondGreaterNumber = 0;
                        secondGreaterNumberPosition = 0;
                    } else {
                        secondGreaterNumber = greaterNumber;
                        secondGreaterNumberPosition = greaterNumberPosition;
                    }

                    greaterNumber = actualNumber;
                    greaterNumberPosition = i;
                } else if (actualNumber > secondGreaterNumber) {
                    //IO.println("\t\tle second plus grand");
                    secondGreaterNumber = actualNumber;
                    secondGreaterNumberPosition = i;
                }
                i++;
            }

            //IO.println("\tFINAL greaterNumber : " + greaterNumber + " at position : " + greaterNumberPosition);
            //IO.println("\tFINAL secondGreaterNumber : " + secondGreaterNumber + " at position : " + secondGreaterNumberPosition);
            String result;
            if (greaterNumberPosition < secondGreaterNumberPosition) {
                result = greaterNumber + "" + secondGreaterNumber;
                IO.println("\tTOTAL => " + result);
            } else {
                result = secondGreaterNumber + "" + greaterNumber;
                IO.println("\tTOTAL => " + result);
            }

            solution = solution.add(new BigInteger(result));
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
