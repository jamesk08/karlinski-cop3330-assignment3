/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 James Karlinski
 */

package Ex43Test;

import ex43.WebsiteBuilder;
import ex43.WebsiteDetails;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

import static org.junit.Assert.*;

public class WebsiteBuilderTests
{
    private static final String TEST_ROOT_PATH = "./src/test/java/ex43Test/websites/";

    @Test
    public void createWebsite_shouldCreateExpectedFoldersAndFiles()
    {
        // arrange
        final String siteName = "Foo";
        final String authorName = "Mr. Foo";
        final String fakeCreateJsFolderInput = "y";
        final String fakeCreateCssFolderInput = "y";
        WebsiteBuilder websiteBuilder = new WebsiteBuilder();

        // initialize website details
        WebsiteDetails websiteDetails = new WebsiteDetails(
            siteName,
            authorName,
            fakeCreateJsFolderInput,
            fakeCreateCssFolderInput,
            TEST_ROOT_PATH
        );

        // build the directory and the files
        websiteBuilder.createWebsite(websiteDetails);

        // assert web directory folder was created
        File websiteDirectory = new File(websiteDetails.websiteDirPath);
        assertTrue((websiteDirectory.exists() && websiteDirectory.isDirectory()));

        // assert index.html file was created
        String indexFilePath = websiteDetails.websiteDirPath + "/" + "index.html";
        File indexFile = new File(indexFilePath);
        assertTrue(indexFile.exists());

        // assert js folder was created
        File jsFolder = new File(websiteDetails.websiteDirPath + "/js");
        assertTrue((jsFolder.exists() && jsFolder.isDirectory()));

        // assert css folder was created
        File cssFolder = new File(websiteDetails.websiteDirPath + "/css");
        assertTrue((cssFolder.exists() && cssFolder.isDirectory()));

        // cleanup test websites
        try {
            FileUtils.deleteDirectory(websiteDirectory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
