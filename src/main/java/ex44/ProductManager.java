/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 James Karlinski
 */

package ex44;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ProductManager
{
    private static final String PRODUCTS = "products";
    private static final String NAME = "name";
    private static final String PRICE = "price";
    private static final String QUANTITY = "quantity";
    private static final Scanner scanner = new Scanner(System.in);
    private List<Product> products = new ArrayList<>();

    public ProductManager(String jsonDataFilePath)
    {
        // read JSON data file and set the products list
        setProductsListFromJsonData(jsonDataFilePath);
    }

    public Product findProduct(String productNameSearchFilter)
    {
        Product productResult = null;
        // iterate all products
        for(Product product : products)
        {
            // check if current product name has a match with users input
            boolean productExists =
                product.name != null &&
                !product.name.isEmpty() &&
                product.name.toLowerCase().contains(productNameSearchFilter.toLowerCase());

            // if match then set the result and get out of the loop
            if (productExists)
            {
                productResult = product;
                break;
            }
        }

        // return product result, could be null or valid
        return productResult;
    }

    public String buildResultMessage(Product productResult)
    {
        // if product is not null then build a display message
        if(productResult != null)
        {
            DecimalFormat decimalFormatter = new DecimalFormat("0.00");
            return MessageFormat.format(
                "Name: {0}\n" +
                "Price: ${1}\n" +
                "Quantity: {2}",
                productResult.name,
                decimalFormatter.format(productResult.price),
                productResult.quantity
            );
        }
        else
        {
            // output not found message
            output("Sorry, that product was not found in our inventory.\n");
            return null;
        }
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
        return scanner.nextLine();
    }

    private JsonElement getValue(JsonElement jsonElement, String jsonNodeName)
    {
        // return the JSON object from given element based on the requested node name
        return jsonElement.getAsJsonObject().get(jsonNodeName);
    }

    private void setProductsListFromJsonData(String jsonDataFilePath)
    {
        // initialize file instance for the JSON data file
        File jsonDataFile = new File(jsonDataFilePath);
        JsonArray allProducts = null;
        try
        {
            // extract the products JSON array from JSON data file
            allProducts = JsonParser
                .parseReader(new FileReader(jsonDataFile))
                .getAsJsonObject()
                .get(PRODUCTS).getAsJsonArray();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            output("Failed to find the JSON data file.");
            System.exit(0);
        }

        if(allProducts != null)
        {
            // iterate all products
            for (JsonElement productElement : allProducts)
            {
                // initialize a product object for each product JSON element
                Product product = new Product(
                    getValue(productElement, NAME).getAsString(),
                    getValue(productElement, PRICE).getAsDouble(),
                    getValue(productElement, QUANTITY).getAsInt()
                );

                // add the product to our available product list
                products.add(product);
            }
        }
    }
}
