/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 James Karlinski
 */

package ex43;

public class WebsiteDetails
{

    public WebsiteDetails(
        String siteName,
        String authorName,
        String createJsFolder,
        String createCssFolder,
        String rootPath)
    {
        // take user inputs and initialize website details
        this.siteName = siteName;
        this.authorName = authorName;
        this.createJsFolder = createJsFolder.equalsIgnoreCase("y");
        this.createCssFolder = createCssFolder.equalsIgnoreCase("y");
        this.websiteDirPath = rootPath + siteName;
    }

    public String htmlTemplate =
        "<!DOCTYPE html>\n" +
            "\t<head>\n" +
                "\t\t<meta charset=\"UTF-8\" />\n" +
                "\t\t<meta name=\"author\" content=\"{0}\" />\n" +
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
