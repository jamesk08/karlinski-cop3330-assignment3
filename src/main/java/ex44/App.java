/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 James Karlinski
 */

package ex44;

public class App
{
    private static final String JSON_DATA_FILE_PATH = "./src/main/java/ex44/exercise44_input.json";

    public static void main(String[] args)
    {
        // initialize an instance of ProductManager and load products list from JSON file
        ProductManager productManager = new ProductManager(JSON_DATA_FILE_PATH);

        // get user input until a product is found
        String foundProductDetailsMessage = productManager.takeSearchInputAndSearch();

        // output the found product details
        productManager.output(foundProductDetailsMessage);
    }
}
