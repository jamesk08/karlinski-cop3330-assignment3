/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 James Karlinski
 */

package ex43;

public class App
{
    public static void main(String[] args)
    {
        // initialize a WebsiteBuilder instance
        WebsiteBuilder websiteBuilder = new WebsiteBuilder();

        // prompt for website requirements
        String siteName = websiteBuilder.getInput("Site name: ");
        String authorName = websiteBuilder.getInput("Author: ");
        String createJsFolder = websiteBuilder.getInput("Do you want a folder for JavaScript? ");
        String createCssFolder = websiteBuilder.getInput("Do you want a folder for CSS? ");

        // initialize a WebsiteDetails object and set the details
        WebsiteDetails websiteDetails = new WebsiteDetails(siteName, authorName, createJsFolder, createCssFolder);

        // build the directory and the files
        websiteBuilder.createWebsite(websiteDetails);
    }
}
