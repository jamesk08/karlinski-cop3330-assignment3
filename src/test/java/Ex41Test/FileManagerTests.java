/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 James Karlinski
 */

package Ex41Test;

import ex41.FileManager;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;

public class FileManagerTests
{
    private static final String OUTPUT_FILE_PATH = "./src/test/java/Ex41Test/exercise41_test_output.txt";
    private static final String INPUT_FILE_PATH = "./src/test/java/Ex41Test/exercise41_test_input.txt";

    @Test
    public void getPeopleListFromFile_shouldReturnExpectedNameList()
    {
        // arrange
        String[] expectedNamesWithExpectedOrder = new String[] { "A, Test", "AB, Test", "B, Test", "C, Test", "D, Test" };
        FileManager fileManager = new FileManager(OUTPUT_FILE_PATH, INPUT_FILE_PATH);

        // act
        ArrayList<String> actualNames = null;
        try {
            // get sorted people list from input file
            actualNames = fileManager.getPeopleListFromFile();
        } catch (Exception e) {
            fail();
        }

        // verify two arrays are equal
        assertArrayEquals(expectedNamesWithExpectedOrder, actualNames.toArray());
    }

    @Test
    public void writePeopleListToOutputFile_shouldWriteExpectedNamesToOutputFile()
    {
        // arrange
        String[] expectedNamesWithExpectedOrder = new String[] {
                "Total of 5 names", "-----------------", "A, Test", "AB, Test", "B, Test", "C, Test", "D, Test" };
        FileManager fileManager = new FileManager(OUTPUT_FILE_PATH, INPUT_FILE_PATH);

        // get sorted people list from input file
        ArrayList<String> actualNames = null;
        try {
            actualNames = fileManager.getPeopleListFromFile();
        } catch (Exception e) {
            fail();
        }

        // write sorted names into the output file
        fileManager.writePeopleListToOutputFile(actualNames);

        // initialize file scanner
        Scanner fileScanner = null;
        try {
            File inputFile = new File(OUTPUT_FILE_PATH);
            fileScanner = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            fail();
        }

        // now read from output file
        ArrayList<String> actualLinesFromOutputFile = new ArrayList<>();

        while (fileScanner.hasNext())
        {
            actualLinesFromOutputFile.add(fileScanner.nextLine());
        }
        fileScanner.close();

        // verify two arrays are equal
        assertArrayEquals(expectedNamesWithExpectedOrder, actualLinesFromOutputFile.toArray());
    }

}
