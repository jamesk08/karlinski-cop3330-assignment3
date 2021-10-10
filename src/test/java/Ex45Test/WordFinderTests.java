/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 James Karlinski
 */

package Ex45Test;

import ex45.WordFinder;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class WordFinderTests
{
    private static final String TEST_INPUT_FILE_PATH = "./src/test/java/ex45Test/exercise45_test_input.txt";
    private static final String TEST_OUTPUT_ROOT_PATH = "./src/test/java/ex45Test/output/";

    @Test
    public void getFileContent_replaceContentAndSaveCreatesOutputFileWithReplacedContent()
    {
        final String OUTPUT_FILENAME = "Glorgybonk";
        String inputFileContent =
            "One should never utilize the word \"utilize\" in writing. Use \"use\" instead.\r\n" +
            "For example, \"She uses an IDE to write her Java programs\" instead of \"She\r\n" +
            "utilizes an IDE to write her Java programs\".";

        String expectedFileContent =
            "One should never use the word \"use\" in writing. Use \"use\" instead.\r\n" +
            "For example, \"She uses an IDE to write her Java programs\" instead of \"She\r\n" +
            "uses an IDE to write her Java programs\".";

        // initialize an instance of WordFinder
        WordFinder wordFinder = new WordFinder(TEST_INPUT_FILE_PATH, TEST_OUTPUT_ROOT_PATH);

        // verify if correct content returned
        String actual = wordFinder.replaceContentAndSave(inputFileContent, OUTPUT_FILENAME);
        assertEquals(expectedFileContent, actual);

        // verify output file was created with the expected name
        File outputFile = new File(TEST_OUTPUT_ROOT_PATH + OUTPUT_FILENAME + ".txt");
        assertTrue(outputFile.exists());

        // verify output file content matches expected content
        String outputFileContent = null;
        try {
            outputFileContent = FileUtils.readFileToString(outputFile, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
        assertEquals(expectedFileContent, outputFileContent);
    }

    @Test
    public void getFileContent_ReturnsExpectedContent()
    {
        // arrange
        String expected =
                "One should never utilize the word \"utilize\" in writing. Use \"use\" instead.\r\n" +
                        "For example, \"She uses an IDE to write her Java programs\" instead of \"She\r\n" +
                        "utilizes an IDE to write her Java programs\".";

        // initialize an instance of WordFinder
        WordFinder wordFinder = new WordFinder(TEST_INPUT_FILE_PATH, TEST_OUTPUT_ROOT_PATH);

        // act
        String actual = wordFinder.getFileContent();

        // assert
        assertEquals(expected, actual);
    }
}
