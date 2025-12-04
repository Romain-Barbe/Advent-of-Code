package org.oramnixe;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;

public class Utils {
    public static ArrayList<String> readInputFile(String inputFileName) throws IOException {
        Path inputFilePath = Paths.get(inputFileName);
        try {
            return (ArrayList<String>) Files.readAllLines(inputFilePath);
        } catch (IOException e) {
            System.out.println("can't open the file " + inputFileName);
            throw new IOException(e);
        }
    }

    public static ArrayList<Character> stringToCharacters(String inputString) {
        ArrayList<Character> charactersList = new ArrayList<>();
        for (char character : inputString.toCharArray()) {
            charactersList.add(character);
        }
        return charactersList;
    }
}