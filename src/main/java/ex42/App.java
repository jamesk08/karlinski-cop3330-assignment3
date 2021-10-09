/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 James Karlinski
 */

package ex42;

import java.util.ArrayList;

public class App
{
    private static final String INPUT_FILE_PATH = "./src/main/java/ex42/exercise42_input.txt";

    public static void main(String[] args)
    {
        // initialize an instance of FileParser
        FileParser fileParser = new FileParser(INPUT_FILE_PATH);

        // get raw lines from input file
        ArrayList<String> lines = fileParser.getRawLines();

        // parse raw lines and make the look pretty
        String displayTable = fileParser.parseTable(lines);

        // display final parsed good-looking table
        fileParser.output(displayTable);
    }
}
