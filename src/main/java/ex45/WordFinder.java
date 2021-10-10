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
        _inputFilePath = inputPath;
        _outputRootPath = outPutRootPath;
    }

    public String getFileContent()
    {
        File file = new File(_inputFilePath);
        String fileContent = null;
        try
        {
            fileContent = FileUtils.readFileToString(file, "UTF-8");
        }
        catch (IOException e)
        {
            e.printStackTrace();
            output("Failed to read from input file.");
            System.exit(0);
        }
        return fileContent;
    }

    public String replaceContentAndSave(String fileContent, String outputFileName)
    {
        String replacedFileContent = fileContent.replaceAll(WORD_TO_FIND, WORD_TO_REPLACE);
        String outputFilePath = _outputRootPath + outputFileName + ".txt";

        File outputFile = new File(outputFilePath);
        if (outputFile.exists()) outputFile.delete();

        try
        {
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
