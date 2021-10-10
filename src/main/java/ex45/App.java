/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 James Karlinski
 */

package ex45;

public class App
{
    private static final String INPUT_FILE_PATH = "./src/main/java/ex45/exercise45_input.txt";
    private static final String OUTPUT_ROOT_PATH = "./src/main/java/ex45/output/";

    public static void main(String[] args)
    {
        WordFinder wordFinder = new WordFinder(INPUT_FILE_PATH, OUTPUT_ROOT_PATH);
        String outputFileNameInput = wordFinder.getInput("Please provide a name for output file: ");
        String inputFileContent = wordFinder.getFileContent();
        String replacedFileContent = wordFinder.replaceContentAndSave(inputFileContent, outputFileNameInput);
        wordFinder.output(replacedFileContent);
    }
}
