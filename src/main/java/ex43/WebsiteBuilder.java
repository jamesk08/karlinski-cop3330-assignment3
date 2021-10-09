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

        boolean directoryCreated = new File(websiteDetails.websiteDirPath).mkdirs();
        if (directoryCreated) output("Created " + websiteDetails.websiteDirPath, true);

        String indexFilePath = websiteDetails.websiteDirPath + "/" + INDEX_FILE_NAME;
        try
        {
            FileWriter fileWriter = new FileWriter(indexFilePath);
            String htmlContent = MessageFormat.format(
                websiteDetails.htmlTemplate,
                websiteDetails.authorName,
                websiteDetails.siteName
            );
            fileWriter.write(htmlContent);
            fileWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            output("Failed to create index file.", true);
            System.exit(0);
        }
        output("Created " + indexFilePath, true);

        if(websiteDetails.createJsFolder)
        {
            String jsFolderPath = websiteDetails.websiteDirPath + "/" + JS_FOLDER_NAME;
            boolean jsFolderCreated = new File(jsFolderPath).mkdir();
            if (jsFolderCreated) output("Created " + jsFolderPath, true);
        }
        if(websiteDetails.createCssFolder)
        {
            String cssFolderPath = websiteDetails.websiteDirPath + "/" + CSS_FOLDER_NAME;
            boolean cssFolderCreated = new File(cssFolderPath).mkdir();
            if (cssFolderCreated) output("Created " + cssFolderPath, true);
        }
    }

    public String getInput(String message)
    {
        output(message, false);
        return scanner.nextLine();
    }

    public void output(String message, boolean needsNewLine)
    {
        System.out.print(message);
        if (needsNewLine) System.out.print("\n");
    }
}

