/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 James Karlinski
 */

package ex43;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Scanner;

public class WebsiteBuilder
{
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INDEX_FILE_NAME = "index.html";
    private static final String JS_FOLDER_NAME = "js";
    private static final String CSS_FOLDER_NAME = "css";

    public void createWebsite(WebsiteDetails websiteDetails)
    {
        // create website directory and output success message
        boolean directoryCreated = new File(websiteDetails.websiteDirPath).mkdirs();
        if (directoryCreated) output("Created " + websiteDetails.websiteDirPath, true);

        // build index file path
        String indexFilePath = websiteDetails.websiteDirPath + "/" + INDEX_FILE_NAME;
        try
        {
            // create index.html file
            FileWriter fileWriter = new FileWriter(indexFilePath);
            String htmlContent = MessageFormat.format(
                websiteDetails.htmlTemplate,
                websiteDetails.authorName,
                websiteDetails.siteName
            );

            // write html content into index.html
            fileWriter.write(htmlContent);
            fileWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            output("Failed to create index file.", true);
            System.exit(0);
        }

        // display success message for index.html file creation
        output("Created " + indexFilePath, true);

        // check if user wanted to create js file
        if(websiteDetails.createJsFolder)
        {
            // build jsFolder path
            String jsFolderPath = websiteDetails.websiteDirPath + "/" + JS_FOLDER_NAME;

            // create js folder and display success message
            boolean jsFolderCreated = new File(jsFolderPath).mkdir();
            if (jsFolderCreated) output("Created " + jsFolderPath, true);
        }

        // check if user wanted to create css file
        if(websiteDetails.createCssFolder)
        {
            // build cssFolder path
            String cssFolderPath = websiteDetails.websiteDirPath + "/" + CSS_FOLDER_NAME;

            // create js folder and display success message
            boolean cssFolderCreated = new File(cssFolderPath).mkdir();
            if (cssFolderCreated) output("Created " + cssFolderPath, true);
        }
    }

    public String getInput(String message)
    {
        // display message and get user input
        output(message, false);

        // return entered value
        return scanner.nextLine();
    }

    public void output(String message, boolean needsNewLine)
    {
        // display message
        System.out.print(message);

        // add a newline character needsNewLine param is true
        if (needsNewLine) System.out.print("\n");
    }
}

