/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 James Karlinski
 */

package Ex44Test;

import ex44.Product;
import ex44.ProductManager;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductManagerTest
{
    private static final String JSON_TEST_FILE_PATH = "./src/test/java/ex44Test/exercise44_test_input.json";

    @Test
    public void findProduct_shouldReturnValidProduct()
    {
        // setup expected values
        final String expectedProductName = "Doodad";
        final double expectedPrice = 5.00;
        final int expectedQuantity = 10;
        ProductManager productManager = new ProductManager(JSON_TEST_FILE_PATH);

        // try finding the product
        Product actualProduct = productManager.findProduct(expectedProductName);

        // verify result is not null and all the properties match expected values
        assertNotNull(actualProduct);
        assertEquals(expectedProductName, actualProduct.name);
        assertEquals(expectedQuantity, actualProduct.quantity);
        assertEquals(expectedPrice, actualProduct.price, 0);
    }

    @Test
    public void findProduct_shouldReturnNull()
    {
        // setup expected values
        final String nonExistingProductName = "{ <o> v <o> }";
        ProductManager productManager = new ProductManager(JSON_TEST_FILE_PATH);

        // try finding the product
        Product actualProduct = productManager.findProduct(nonExistingProductName);

        // verify result is not null and all the properties match expected values
        assertNull(actualProduct);
    }

    @Test
    public void buildResultMessage_ReturnsExpectedMessage()
    {
        // setup parameters and expected values
        final String productName = "Doodad";
        final double price = 5.00;
        final int quantity = 10;
        Product product = new Product(productName, price,quantity);
        final String expected =
            "Name: Doodad\n" +
            "Price: $5.00\n" +
            "Quantity: 10";

        // initialize an instance for ProductManager
        ProductManager productManager = new ProductManager(JSON_TEST_FILE_PATH);

        // invoke buildResultMessage
        String actual = productManager.buildResultMessage(product);

        // assert to verify match between expected and actual messages
        assertEquals(expected, actual);
    }
}
