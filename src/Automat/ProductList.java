package Automat;

import java.util.ArrayList;

/**
 * Created by Jannik on 24.04.2018.
 */
public class ProductList {
    public static ArrayList<Product> putProductFromInputInProductList(ArrayList<Product> listOfProducts ,String prodBez, String preis, String menge){
        try{
            Integer preisInt = Integer.valueOf(preis);
            Integer mengeInt = Integer.valueOf(menge);
            Product newProduct = new Product(prodBez, preisInt, mengeInt);
            listOfProducts.add(newProduct);

        } catch (NumberFormatException e) { //Catch wrong input
            System.out.println("Bitte valide Eingaben tätigen.");
        }
        return listOfProducts;
    }
 }