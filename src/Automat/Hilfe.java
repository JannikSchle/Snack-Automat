package Automat;

import java.util.ArrayList;

/**
 * Created by Jannik on 29.04.2018.
 */
public class Hilfe {
    private static ArrayList<Product> deleteProductsFromListWithMeange0(ArrayList<Product> listOfProducts){
        for(int i = 0; i < listOfProducts.size(); i++){
            if(listOfProducts.get(i).getMenge() == 0){
                listOfProducts.remove(i);
            }
        }
        return listOfProducts;
    }
}
