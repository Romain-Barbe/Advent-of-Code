package org.oramnixe;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

public class Day2 {
    static void main() throws IOException {
        int dayNumber = 2;
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

        String line = inputFileContent.getFirst();

        for (String idRange : line.split(",")) {
            BigInteger firstId = new BigInteger(idRange.split("-")[0]);
            BigInteger secondId = new BigInteger(idRange.split("-")[1]);

            for (BigInteger id = firstId; id.compareTo(secondId) <= 0; id = id.add(BigInteger.ONE)) {
                if (isInvalid(id)) {
                    solution = solution.add(id);
                }
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
