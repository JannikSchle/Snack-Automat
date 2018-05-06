package Automat;

import java.util.ArrayList;

/**
 * Created by Jannik on 06.05.2018.
 */
public class ProductBin {
    // Deletes every Product with menge = 0
    public static ArrayList<Product> deleteProductsFromListWithMenge0(ArrayList<Product> listOfProducts){
        for(int i = 0; i < listOfProducts.size(); i++){
            if(listOfProducts.get(i).getMenge() == 0){
                listOfProducts.remove(i);
            }
        }
        return listOfProducts;
    }
}
