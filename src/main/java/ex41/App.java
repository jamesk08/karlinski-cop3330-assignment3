/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 James Karlinski
 */

package ex41;

import java.util.ArrayList;

public class App
{
    private static final String OUTPUT_FILE_PATH = "./src/main/java/ex41/exercise41_output.txt";
    private static final String INPUT_FILE_PATH = "./src/main/java/ex41/exercise41_input.txt";

    public static void main(String[] args)
    {
        // initialize a FileManager instance
        FileManager fileManager = new FileManager(OUTPUT_FILE_PATH, INPUT_FILE_PATH);

        // get sorted people list from input file
        ArrayList<String> peopleList = fileManager.getPeopleListFromFile();

        // write sorted names to the output file
        fileManager.writePeopleListToOutputFile(peopleList);
    }
}
