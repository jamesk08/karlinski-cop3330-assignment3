/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 James Karlinski
 */

package ex41;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class App
{
    public static void main(String args[]) throws FileNotFoundException
    {
        // initialize FileManager
        FileManager fileManager = new FileManager();

        // get sorted people list from input file
        ArrayList<String> peopleList = fileManager.getPeopleListFromFile();

        // write sorted names to the output file
        fileManager.writePeopleListToOutputFile(peopleList);
    }
}
