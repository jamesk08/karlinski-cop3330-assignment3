/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 James Karlinski
 */

package ex46;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.util.*;

public class WordFrequencyFinder
{
    private static String _inputFilePath = "";

    public WordFrequencyFinder(String inputPath)
    {
        // set the input and output values on initialization
        _inputFilePath = inputPath;
    }

    public Map<String, Integer> readFromFile()
    {
        Map<String, Integer> wordsAndCounts = new LinkedHashMap<>();
        Scanner fileScanner = null;
        try
        {
            // create a file instance
            File file = new File(_inputFilePath);

            // create fileScanner
            fileScanner = new Scanner(file);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            output("Failed to read from input file.");
            System.exit(0);
        }

        while (fileScanner.hasNext())
        {
            // get key (snake, mushroom or badger)
            String key = fileScanner.next();

            // if null that means current value hasn't been set before so its
            int currentCount = wordsAndCounts.get(key) != null
                ? wordsAndCounts.get(key) + 1
                : 1;

            // add it to key value pair
            wordsAndCounts.put(key, currentCount);
        }

        return wordsAndCounts;
    }

    public List<Map.Entry<String, Integer>> sortWords(Map<String, Integer> wordsAndCounts)
    {
        // create a list from the key value pair
        List<Map.Entry<String, Integer>> wordsList = new ArrayList<>(wordsAndCounts.entrySet());

        // sort the list
        wordsList.sort(Map.Entry.comparingByValue());

        // return sorted list
        return wordsList;
    }

    public String buildDisplayMessage(List<Map.Entry<String, Integer>> sortedWords)
    {
        StringBuilder stringBuilder = new StringBuilder();

        // build a result message using sorted words and their usage count
        // because list is sorted, loop reverse
        for (int i = sortedWords.size() - 1; i >= 0; i--)
        {
            // adjust spaces so it would look good
            String word = String.format("%-9s", sortedWords.get(i).getKey() + ":");
            String stars = String.format("%-5s", getStars(sortedWords.get(i).getValue()));

            // create a string for the word and its usage
            String wordAndCountMessage = MessageFormat.format("{0} {1}\n", word, stars);
            stringBuilder.append(wordAndCountMessage);
        }

        // return result message
        return stringBuilder.toString();
    }

    private String getStars(int usageCount)
    {
        // build a string that contains same amount of * character as usageCount
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < usageCount; i++)
        {
            stringBuilder.append("*");
        }
        return stringBuilder.toString();
    }

    public void output(String message)
    {
        System.out.print(message);
    }
}
