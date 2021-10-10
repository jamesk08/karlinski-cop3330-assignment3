/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 James Karlinski
 */

package Ex46Test;

import ex46.WordFrequencyFinder;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class WordFrequencyFinderTests
{
    private static final String INPUT_FILE_PATH = "./src/test/java/ex46Test/exercise46_test_input.txt";

    @Test
    public void readFromFile_returnsExpectedResult()
    {
        Map<String, Integer> expected = new LinkedHashMap<>();
        expected.put("snake", 1);
        expected.put("badger", 7);
        expected.put("mushroom", 2);

        // initialize an instance of WordFrequencyFinder
        WordFrequencyFinder wordFrequencyFinder = new WordFrequencyFinder(INPUT_FILE_PATH);

        // read words from input file and calculate their usage counts
        Map<String, Integer> actual = wordFrequencyFinder.readFromFile();

        // assert if result is matching expectation
        assertNotNull(actual);
        assertEquals(expected.size(), actual.size());
        assertEquals(expected.get("snake"), actual.get("snake"));
        assertEquals(expected.get("mushroom"), actual.get("mushroom"));
        assertEquals(expected.get("badger"), actual.get("badger"));
    }

    @Test
    public void sortWords_returnsExpectedSortedKeyValuePair()
    {
        // arrange expected
        Map<String, Integer> expected = new LinkedHashMap<>();
        expected.put("mushroom", 2);
        expected.put("badger", 7);
        expected.put("snake", 1);

        // initialize an instance of WordFrequencyFinder
        WordFrequencyFinder wordFrequencyFinder = new WordFrequencyFinder(INPUT_FILE_PATH);

        // sort words and counts collection
        List<Map.Entry<String, Integer>> actual = wordFrequencyFinder.sortWords(expected);

        // assert if actual meets expectation
        assertEquals(expected.get("badger"), actual.get(2).getValue());
        assertEquals(expected.get("snake"), actual.get(0).getValue());
        assertEquals(expected.get("mushroom"), actual.get(1).getValue());
    }

    @Test
    public void buildDisplayMessage_returnsExpectedResult()
    {
        // arrange initialize unsorted key value pair to use it as parameter
        Map<String, Integer> unsorted = new LinkedHashMap<>();
        unsorted.put("mushroom", 2);
        unsorted.put("badger", 7);
        unsorted.put("snake", 1);

        final String expected =
            "badger:   *******\n" +
            "mushroom: **   \n" +
            "snake:    *    \n";

        // initialize an instance of WordFrequencyFinder
        WordFrequencyFinder wordFrequencyFinder = new WordFrequencyFinder(INPUT_FILE_PATH);

        // sort words and counts
        List<Map.Entry<String, Integer>> sortedWordsAndCounts = wordFrequencyFinder.sortWords(unsorted);

        // use sorted words and their counts to build the display message
        String actual = wordFrequencyFinder.buildDisplayMessage(sortedWordsAndCounts);

        // verify output message matches expected
        assertEquals(expected, actual);
    }
}
