/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 James Karlinski
 */

package ex43;

public class WebsiteDetails
{
    private static final String ROOT_PATH = "./src/main/java/ex43/websites/";

    public WebsiteDetails(String siteName, String authorName, String createJsFolder, String createCssFolder)
    {
        // take user inputs and initialize website details
        this.siteName = siteName;
        this.authorName = authorName;
        this.createJsFolder = createJsFolder.equalsIgnoreCase("y");
        this.createCssFolder = createCssFolder.equalsIgnoreCase("y");
        this.websiteDirPath = ROOT_PATH + siteName;
    }

    public String htmlTemplate =
        "<!DOCTYPE html>\n" +
            "\t<head>\n" +
                "\t\t<meta charset=\"utf-8\" />\n" +
                "\t\t<meta name=\"Author: {0}\" content=\"%s\" />\n" +
                "\t\t<title>{1}</title>\n" +
            "\t</head>\n" +
            "\t<body>\n" +
                "\t\tWelcome to {1}! 🎉" +
            "\t</body>\n" +
        "</html>";

    public String siteName = "";
    public String authorName = "";
    public String websiteDirPath = "";
    public boolean createJsFolder;
    public boolean createCssFolder;
}
