/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 James Karlinski
 */

package ex44;

public class Product
{
    public Product(String name, double price, int quantity)
    {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String name = "";
    public int quantity;
    public double price;
}
