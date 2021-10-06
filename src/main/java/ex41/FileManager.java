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
    private static final String OUTPUT_FILE_NAME = "./src/main/java/ex41/exercise41_output.txt";
    private static final String INPUT_FILE_NAME = "./src/main/java/ex41/exercise41_input.txt";

    public ArrayList<String> getPeopleListFromFile() throws FileNotFoundException
    {
        // Initialize file using the input file name
        File inputFile = new File(INPUT_FILE_NAME);

        // Check if input file exists
        if (!inputFile.exists())
        {
            // Output failure and exit
            output("Input file was not found.");
            System.exit(0);
        }

        // Create file scanner
        Scanner fileScanner = new Scanner(inputFile);

        // initialize people list to store list items read from input file
        ArrayList<String> peopleList = new ArrayList<>();

        // check if line exists then loop each line and add line item
        while (fileScanner.hasNext())
        {
            peopleList.add(fileScanner.nextLine());
        }
        // close file scanner
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

            // initialize file writer
            FileWriter fileWriter = new FileWriter(outputFile);

            // append header and divider to the output file
            fileWriter.append(MessageFormat.format("Total of {0} names\n", peopleList.size()));
            fileWriter.append("-----------------\n");

            // loop through each item in people list
            for (String person: peopleList)
            {
                // write the current person name into the file
                fileWriter.append(person + "\n");
            }

            // close file writer
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
        Path outputFilePath = Paths.get(OUTPUT_FILE_NAME);
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

        // initialize new file object
        File newOutputFile = new File(OUTPUT_FILE_NAME);
        try
        {
            // create the new output file in directory
            newOutputFile.createNewFile();
        }
        catch (IOException e)
        {
            output("Failed to create new output file.");
            System.exit(0);
        }

        // return newly created file
        return newOutputFile;
    }
}
