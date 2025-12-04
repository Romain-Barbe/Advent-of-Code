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
        test1.solve();
        System.out.println("--------------------------------------------------");
        System.out.println("DAY " + dayNumber + " REAL DATA :");
        Day1 realData = new Day1(Utils.readInputFile("inputs/day" + dayNumber + "/day" + dayNumber + ".txt"));
        realData.solve();
        System.out.println("--------------------------------------------------");
    }

    private void solve() {
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
                    //password ++;
                }
            } else {
                position -= numberOfRotation;
                while (position < 0) {
                    position += 100;
                    //password ++;
                }
            }

            //IO.println("new position = " + position);
            if (position == 0) password++;
        }

        System.out.println("Part 1 result : " + password);
        /*System.out.println("Part 2 result : " + finalSimilarityScore);*/
    }
}
