/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 James Karlinski
 */

package ex41;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FileManager
{
    private static String _outputFilePath = "";
    private static String _inputFilePath = "";

    public FileManager(String outPutFilePath, String inputFilePath)
    {
        _outputFilePath = outPutFilePath;
        _inputFilePath = inputFilePath;
    }

    public ArrayList<String> getPeopleListFromFile()
    {
        // initialize file scanner
        Scanner fileScanner = null;
        try {
            File inputFile = new File(_inputFilePath);
            fileScanner = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            output("Failed to find the file.");
            System.exit(0);
        }

        // read from input file
        ArrayList<String> peopleList = new ArrayList<>();
        while (fileScanner.hasNext())
        {
            // add each line to peopleList
            peopleList.add(fileScanner.nextLine());
        }
        fileScanner.close();

        // sort people list
        sortPeopleList(peopleList);

        // return sorted people list
        return peopleList;
    }

    public void writePeopleListToOutputFile(ArrayList<String> peopleList)
    {
        try
        {
            // create new file for each execution
            File outputFile = createOutputFile();

            // initialize a new file writer instance
            FileWriter fileWriter = new FileWriter(outputFile);

            // append header and divider to the output file
            fileWriter.append(MessageFormat.format("Total of {0} names\n", peopleList.size()));
            fileWriter.append("-----------------\n");

            // loop through each item in people list
            for (String person: peopleList)
            {
                // write the current person's name into the output file
                fileWriter.append(person).append("\n");
            }
            fileWriter.close();
        }
        catch (IOException e)
        {
            output("Failed to write to output file.");
            System.exit(0);
        }
    }

    private void sortPeopleList(ArrayList<String> peopleList)
    {
        // sort people list
        Collections.sort(peopleList);
    }

    private void output(String message)
    {
        // output message
        System.out.print(message);
    }

    private File createOutputFile() throws IOException
    {
        // initialize the path object for output file
        Path outputFilePath = Paths.get(_outputFilePath);
        try
        {
            // delete the existing output file if exists
            Files.deleteIfExists(outputFilePath);
        }
        catch (IOException e)
        {
            output("Failed to delete existing output file.");
            System.exit(0);
        }

        // create the new output file in directory
        File newOutputFile = new File(_outputFilePath);
        newOutputFile.createNewFile();

        // return a new output file
        return newOutputFile;
    }
}
