/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 James Karlinski
 */

package Ex42Test;

import ex42.FileParser;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FileParserTest
{
    private static final String INPUT_FILE_PATH = "./src/test/java/Ex42Test/exercise42_test_input.txt";

    @Test
    public void getRawLines_shouldReturnExpected()
    {
        // arrange
        String[] expectedArray = new String[]
        {
            "Ling,Mai,55900",
            "Johnson,Jim,56500",
            "Jones,Aaron,46000",
            "Jones,Chris,34500",
            "Swift,Geoffrey,14200",
            "Xiong,Fong,65000",
            "Zarnecki,Sabrina,51500"
        };
        FileParser fileParser = new FileParser(INPUT_FILE_PATH);

        // act
        // get the raw lines from input file
        ArrayList<String> actualRawLines = fileParser.getRawLines();

        // assert
        // verify that expected raw line array and the actual array are equal
        assertArrayEquals(expectedArray, actualRawLines.toArray());
    }

    @Test
    public void parseTable_shouldReturnExpected()
    {
        // arrange
        String expected =
            "Last      First     Salary    \n" +
            "---------------------------\n" +
            "Ling      Mai       55900     \n" +
            "Johnson   Jim       56500     \n" +
            "Jones     Aaron     46000     \n" +
            "Jones     Chris     34500     \n" +
            "Swift     Geoffrey  14200     \n" +
            "Xiong     Fong      65000     \n" +
            "Zarnecki  Sabrina   51500     \n";
        FileParser fileParser = new FileParser(INPUT_FILE_PATH);

        // get the raw lines from input file
        ArrayList<String> rawLines = fileParser.getRawLines();

        // act
        // get the output lines from input file
        String actual = fileParser.parseTable(rawLines);

        // assert
        // verify expected and actual output are equal
        assertEquals(expected, actual);
    }
}
