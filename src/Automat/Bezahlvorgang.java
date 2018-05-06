package Automat;

import Coins.Coin;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Jannik on 03.05.2018.
 */
public class Bezahlvorgang {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Coin> geldsack = new ArrayList<>();
    public static ArrayList<Coin> bezahlen(ArrayList<Coin> geldsack, int price){
        try{
        Bezahlvorgang.geldsack = geldsack;
        System.out.println("Bitte Geld einwerfen:");
        while(price > 0) {
            System.out.println("Zu zahlen: " + (float)price/100 + "€");
            System.out.println("[1] 10 cent einwerfen");
            System.out.println("[2] 20 cent einwerfen");
            System.out.println("[3] 50 cent einwerfen");
            System.out.println("[4] 1€ einwerfen");
            System.out.println("[5] 2€ einwerfen");

            String eingabe = scanner.nextLine();
            Integer eingabeInt = Integer.parseInt(eingabe);
            if(eingabeInt > 0 && eingabeInt <= 5) {
                price = price - geldsack.get(eingabeInt - 1).getWert();
                Bezahlvorgang.geldsack.get(eingabeInt - 1).setMenge(Bezahlvorgang.geldsack.get(eingabeInt - 1).getMenge() + 1);
            }
            else{
                System.out.println("Bitte eine der Optionen wählen");
                bezahlen(geldsack,price);
            }
        }
        System.out.println("Vielen dank für ihren Einkauf!");
        System.out.println("Sie bekommen Wechselgeld in höhe von " + (float)Math.abs(price)/100 + "€.");
        gibWechselgeld(price);

        } catch (NumberFormatException e) { //Catch wrong input
            System.out.println("Bitte valide Eingaben tätigen.");
        }
        return Bezahlvorgang.geldsack;
    }
    private static void gibWechselgeld(int price){
        price = Math.abs(price);
        if(price != 0) {
            System.out.print("Ihr Rückgeld: ");
        }
        while(price>0){
            if(price>=100&&geldsack.get(3).getMenge()>0){
                price = price - geldsack.get(3).getWert();
                Bezahlvorgang.geldsack.get(3).setMenge(geldsack.get(3).getMenge() - 1);
                System.out.print(" 1,00€ ");
            }
            else if(price>=50&&geldsack.get(2).getMenge()>0){
                price = price - geldsack.get(2).getWert();
                Bezahlvorgang.geldsack.get(2).setMenge(geldsack.get(2).getMenge() - 1);
                System.out.print(" 0,50€ ");
            }
            else if(price>=20&&geldsack.get(1).getMenge()>0){
                price = price - geldsack.get(1).getWert();
                Bezahlvorgang.geldsack.get(1).setMenge(geldsack.get(1).getMenge() - 1);
                System.out.print(" 0,20€ ");
            }
            else if(price>=10&&geldsack.get(0).getMenge()>0){
                price = price - geldsack.get(0).getWert();
                Bezahlvorgang.geldsack.get(0).setMenge(geldsack.get(0).getMenge() - 1);
                System.out.print(" 0,10€ ");
            }
            else{
                System.out.println("");
                System.out.println("Leider können die restlichen " + price/100 + "€ nicht ausgegeben werden.");
                return;
            }
        }
        System.out.println("");
        }
}
