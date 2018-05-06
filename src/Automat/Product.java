package Automat;

import java.util.UUID;

/**
 * Created by Jannik on 18.04.2018.
 */
public class Product {
    private UUID productId;
    private String productBez;
    private int price;
    private int menge;

    public Product(String productBez, int price, int menge){
        this.productId = UUID.randomUUID();
        this.productBez = productBez;
        this.price = price;
        this.menge = menge;
    }

    public UUID getProductId() {
        return productId;
    }

    public String getProductBez() {
        return productBez;
    }

    public void setProductBez(String productBez) {
        this.productBez = productBez;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }
}