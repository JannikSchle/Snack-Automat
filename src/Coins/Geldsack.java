package Coins;

import java.util.ArrayList;

/**
 * Created by Jannik on 02.05.2018.
 */
public class Geldsack {
    private static Cent10 cent10 = new Cent10(10);
    private static Cent20 cent20 = new Cent20(10);
    private static Cent50 cent50 = new Cent50(10);
    private static Euro1 euro1 = new Euro1(10);
    private static Euro2 euro2 = new Euro2(10);
    private static ArrayList<Coin> geldsackList = new ArrayList<>();


    public static ArrayList<Coin> createGeldsack(){
        geldsackList.add(cent10);
        geldsackList.add(cent20);
        geldsackList.add(cent50);
        geldsackList.add(euro1);
        geldsackList.add(euro2);
        return geldsackList;
    }
}
