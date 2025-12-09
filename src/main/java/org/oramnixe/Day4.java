package org.oramnixe;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

public class Day4 {
    static void main() throws IOException {
        int dayNumber = 4;
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
        //IO.println(inputFileContent);
        for (String s : inputFileContent) {
            IO.println(s);
        }

        BigInteger solution = BigInteger.ZERO;

        for (int i = 0; i < inputFileContent.size(); i++) {
            var lineSplitted = inputFileContent.get(i).split("");
            for (int j = 0; j < lineSplitted.length; j++) {
                if (lineSplitted[j].equals("@")) {
                    var numberOfNeighbors = getNumberOfNeighbors(inputFileContent, i, j);
                    if (numberOfNeighbors < 4) {
                        solution = solution.add(BigInteger.ONE);
                    }
                }
            }
        }

        IO.println("Part 1 result : " + solution);
    }

    private static int getNumberOfNeighbors(ArrayList<String> inputFileContent, int i, int j) {
        var numberOfNeighbors = 0;
        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                if (k >= 0 && k < inputFileContent.size() && l >= 0 && l < inputFileContent.size() && !(k == i && l == j)) {
                    var character = inputFileContent.get(k).split("")[l];
                    if (character.equals("@")) {
                        numberOfNeighbors++;
                    }
                }
            }
        }
        return numberOfNeighbors;
    }
}
