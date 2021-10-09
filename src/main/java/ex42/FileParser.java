/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 James Karlinski
 */

package ex42;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileParser
{
    private static String _inputFilePath = "";

    public FileParser(String inputFilePath)
    {
        _inputFilePath = inputFilePath;
    }

    public ArrayList<String> getLinesFromInputFile()
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

        ArrayList<String> rawLines = new ArrayList<>();
        while (fileScanner.hasNextLine())
        {
            // read the line and add the read value to rawLines list
            rawLines.add(fileScanner.nextLine());
        }
        fileScanner.close();

        // return non-parsed, raw lines
        return rawLines;
    }

    public String parseTable(ArrayList<String> rawLines)
    {
        // initialize a StringBuilder instance
        StringBuilder stringBuilder = new StringBuilder();

        // append header section
        stringBuilder.append(parseRawLine("Last,First,Salary"));
        stringBuilder.append("---------------------------\n");


        for (String rawLine: rawLines)
        {
            // parse the raw line
            String parsedLine = parseRawLine(rawLine);

            // append the parsed and formatted line to our display string
            stringBuilder.append(parsedLine);
        }

        // return finished display table string
        return stringBuilder.toString();
    }

    private String parseRawLine(String rawLine)
    {
        // create a string array by splitting values by comma
        String[] columns = rawLine.split(",");

        // loop all column values and format them
        StringBuilder rowStringBuilder = new StringBuilder();
        for (String column : columns) {
            String parsedColumn = String.format("%-10s", column);
            rowStringBuilder.append(parsedColumn);
        }

        // return parsed and formatted good-looking line
        return rowStringBuilder.append("\n").toString();
    }

    public void output(String message)
    {
        // output message
        System.out.print(message);
    }
}
