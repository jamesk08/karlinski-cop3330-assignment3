/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 James Karlinski
 */

package ex46;

import java.util.List;
import java.util.Map;

public class App
{
    private static final String INPUT_FILE_PATH = "./src/main/java/ex46/exercise46_input.txt";

    public static void main(String[] args)
    {
        // initialize an instance of WordFrequencyFinder
        WordFrequencyFinder wordFrequencyFinder = new WordFrequencyFinder(INPUT_FILE_PATH);

        // read words from input file and calculate their usage counts
        Map<String, Integer> wordsAndCounts = wordFrequencyFinder.readFromFile();

        // sort the words and counts collection
        List<Map.Entry<String, Integer>> sortedWordsAndCounts = wordFrequencyFinder.sortWords(wordsAndCounts);

        // use sorted words and their counts to build the display message
        String resultMessage = wordFrequencyFinder.buildDisplayMessage(sortedWordsAndCounts);

        // display result
        wordFrequencyFinder.output(resultMessage);
    }
}
