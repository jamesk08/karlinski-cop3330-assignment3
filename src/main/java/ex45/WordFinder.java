/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 James Karlinski
 */

package ex45;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.Scanner;

public class WordFinder
{
    private static final Scanner consoleScanner = new Scanner(System.in);
    private static final String WORD_TO_FIND = "utilize";
    private static final String WORD_TO_REPLACE = "use";

    private static String _outputRootPath = "";
    private static String _inputFilePath = "";

    public WordFinder(String inputPath, String outPutRootPath)
    {
        // set the input and output values on initialization
        _inputFilePath = inputPath;
        _outputRootPath = outPutRootPath;
    }

    public String getFileContent()
    {
        // initialize an instance of input file
        File file = new File(_inputFilePath);

        String fileContent = null;
        try
        {
            // read the input file content
            fileContent = FileUtils.readFileToString(file, "UTF-8");
        }
        catch (IOException e)
        {
            e.printStackTrace();
            output("Failed to read from input file.");
            System.exit(0);
        }

        // return the input file content
        return fileContent;
    }

    public String replaceContentAndSave(String fileContent, String outputFileName)
    {
        // replace all the instances of the word "utilize" to "use"
        String replacedFileContent = fileContent.replaceAll(WORD_TO_FIND, WORD_TO_REPLACE);

        // build the path for the output file
        String outputFilePath = _outputRootPath + outputFileName + ".txt";

        // initialize output file
        File outputFile = new File(outputFilePath);

        // delete the file if exists
        if (outputFile.exists()) outputFile.delete();

        try
        {
            // create the output file
            outputFile.createNewFile();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            output("Failed to create output file.");
            System.exit(0);
        }

        try
        {
            // initialize writer and write the replaced content into the output file
            FileWriter fileWriter = new FileWriter(outputFile);
            fileWriter.write(replacedFileContent);
            fileWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            output("Failed to write into the output file.");
            System.exit(0);
        }

        // return the replaced file content
        return replacedFileContent;
    }

    public void output(String message)
    {
        // display user message
        System.out.print(message);
    }

    public String getInput(String message)
    {
        // display a prompt for user
        output(message);

        // return user's entry
        return consoleScanner.nextLine();
    }
}
