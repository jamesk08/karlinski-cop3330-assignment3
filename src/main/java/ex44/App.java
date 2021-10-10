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
        // get user product name criteria from user until a product is found
        startSearch();
    }

    private static void startSearch()
    {
        // initialize an instance of ProductManager and load products list from JSON file
        ProductManager productManager = new ProductManager(JSON_DATA_FILE_PATH);

        // get user product name criteria from user until a product is found
        Product productResult = null;
        do
        {
            // get product name from input
            String productNameSearchFilter = productManager.getInput("What is the product name? ");

            // try finding a product from products with provided user input
            productResult = productManager.findProduct(productNameSearchFilter);

            String productResultMessage = productManager.buildResultMessage(productResult);

            // output the found product details
            productManager.output(productResultMessage);

            // let user try again if product result is null
        } while(productResult == null);
    }
}
