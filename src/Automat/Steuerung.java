package Automat;

import Coins.Geldsack;
import Coins.Coin;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Jannik on 18.04.2018.
 */
public class Steuerung {
    private ArrayList<Coin> geldsack = Geldsack.createGeldsack();
    private ArrayList<Product> listOfProducts = new ArrayList<>();

    public void hauptmenue(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Was möchten sie machen?");
        System.out.println("[1] Produkt hinzufügen");
        System.out.println("[2] Produkte auffüllen");
        System.out.println("[3] Wechselgeld auffüllen");
        System.out.println("[4] Snack auswählen");
        String eingabe = scanner.nextLine();
        if(eingabe.equals("1")||eingabe.equals("2")||eingabe.equals("3")||eingabe.equals("4"))
        switch(eingabe){
            case "1":
                addProduct();
                hauptmenue();
                break;
            case "2":
                fillProduct();
                hauptmenue();
                break;
            case "3":
                fillChange();
                hauptmenue();
                break;
            case "4":
                chooseSnack();
                hauptmenue();
                break;
        }
        else{
            System.out.println("Bitte zwischen 1 2 3 oder 4 wählen");
            hauptmenue();
        }
    }
    //creates a product from string input and adds it to the listOfProducts Arraylist
    private ArrayList<Product> addProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte geben sie die Bezeichnung des Produkts an:");
        String prodBez = scanner.nextLine();
        System.out.println("Bitte geben sie den Preis des Produkts in Cent an:");
        String preis = scanner.nextLine();
        System.out.println("wie viele " + prodBez + " möchten sie hinzufügen?");
        String menge = scanner.nextLine();

        //pass the input and gets the old listOfArrays
        listOfProducts = ProductList.putProductFromInputInProductList(listOfProducts,prodBez,preis,menge);
        return listOfProducts;
    }

    //fills the amount of a Product depending on user input
    private void fillProduct(){
        try{
            Scanner scanner = new Scanner(System.in);
            if (!listOfProducts.isEmpty()) {
                System.out.println("Den Bestand welches Produkts möchten sie auffüllen?:");
                for (int i = 0; listOfProducts.size() > i; i++) {
                    System.out.println("[" + (i + 1) + "] " + listOfProducts.get(i).getProductBez() + " : " + listOfProducts.get(i).getMenge() + " Stk.");
                }
                System.out.println("[0] Zurück zum Hauptmenü");
                String eingabeUser  = scanner.nextLine();
                Integer userAuswahl = Integer.parseInt(eingabeUser);
                if(userAuswahl <= listOfProducts.size()&&userAuswahl > 0){
                    System.out.println("Aktuell sind noch " + listOfProducts.get(userAuswahl - 1).getMenge() + " " + listOfProducts.get(userAuswahl - 1).getProductBez() + " verfügbar.");
                    System.out.println("Wie viele " + listOfProducts.get(userAuswahl - 1).getProductBez() + " möchten sie hinzufügen?");
                    String eingabeMenge  = scanner.nextLine();
                    Integer userMenge = Integer.parseInt(eingabeMenge);
                    if(userMenge <= 1000){
                        listOfProducts.get(userAuswahl - 1).setMenge(listOfProducts.get(userAuswahl - 1).getMenge() + userMenge);
                        System.out.println("Vielen Dank! Die neue Stückzahl beträgt " + listOfProducts.get(userAuswahl - 1).getMenge());
                    }
                    else if(userMenge > 1000){
                        System.out.println("Es können maximal 1000 Stk. pro Aktion aufgefüllt werden.");
                        fillProduct();
                    }
                    else{
                        System.out.println("Bitte machen sie eine Mengenangabe.");
                        fillProduct();
                    }
                }
                else if(userAuswahl == 0){}
                else{
                    System.out.println("Bitte zwischen 1 und " + (listOfProducts.size()) + " wählen");
                    System.out.println("oder mit 0 zurück zum Hauptmenü navigieren.");
                    fillProduct();
                }
            }
            else{
                System.out.println("Aktuell gibt es keine Produkte.");
                System.out.println("Möchten sie ein Produkt hinzufügen?");
                System.out.println("[1] Ja");
                String eingabe = scanner.nextLine();
                if (eingabe.equals("1")){
                    addProduct();
                }
            }
        } catch (NumberFormatException e) { //Catch wrong input
            System.out.println("Bitte valide Eingaben tätigen.");
        }
    }

    private void fillChange(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Aktueller Münzbestand:");
            for(int i = 0; geldsack.size() > i; i++){
                System.out.println("["+(i + 1) +"] " + geldsack.get(i).getBez() + " : " + Math.round(geldsack.get(i).getMenge()));
            }
            System.out.println("[0] Zurück zum Hauptmenü");
            String eingabeUser  = scanner.nextLine();
            Integer userAuswahl = Integer.parseInt(eingabeUser);
            if(userAuswahl <= geldsack.size() && userAuswahl > 0) {
                    System.out.println("Wie viele Geldstücke möchten sie hinzufügen?");
                    String eingabeMenge = scanner.nextLine();
                    Integer userMenge = Integer.parseInt(eingabeMenge);
                    if(userMenge <= 1000){
                        geldsack.get(userAuswahl - 1).setMenge(geldsack.get(userAuswahl - 1).getMenge() + userMenge);
                        System.out.println("Vielen Dank! Die neue Stückzahl beträgt " + geldsack.get(userAuswahl - 1).getMenge() + ".");
                    }
                    else if(userMenge > 1000){
                        System.out.println("Es können maximal 1000 Geldstücke pro Aktion aufgefüllt werden.");
                        fillChange();
                    }
                    else{
                        System.out.println("Bitte tätigen sie eine geeignete Mengenangabe unter 1000.");
                        fillChange();
                    }
                }
            else if(userAuswahl == 0){}
            else{
                System.out.println("Bitte zwischen 1 und " + (listOfProducts.size() - 1) + " wählen.");
                System.out.println("oder mit 0 zurück zum Hauptmenü navigieren,");
            }
        } catch (NumberFormatException e) { //Catch wrong input
            System.out.println("Bitte valide Eingaben tätigen.");
        }
    }

    private void chooseSnack(){

        try{
            Scanner scanner = new Scanner(System.in);
            if (!listOfProducts.isEmpty()){
                System.out.println("Bitte wählen sie einen der unten aufgeführen Snacks:");
                for(int i = 0; listOfProducts.size() > i; i++){
                    System.out.println("["+(i + 1) +"] " + listOfProducts.get(i).getProductBez() + " : " + (float)listOfProducts.get(i).getPrice()/100 + "€ : " + listOfProducts.get(i).getMenge() + " Stk verbleibend.");
                }
                System.out.println("[0] Zurück zum Hauptmenü");
                String eingabe = scanner.nextLine();
                Integer eingabeInt = Integer.parseInt(eingabe);
                if(eingabeInt <= listOfProducts.size() && eingabeInt > 0){
                    listOfProducts.get(eingabeInt - 1).setMenge(listOfProducts.get(eingabeInt - 1).getMenge() - 1);
                    System.out.println("Das macht dann " + (float)listOfProducts.get(eingabeInt - 1).getPrice()/100 + "€.");
                    System.out.println("Sind sie sich sicher?");
                    System.out.println("[1] Ja");
                    String bestätigung = scanner.nextLine();
                    Integer bestaetigungInt = Integer.parseInt(eingabe);
                    if(bestaetigungInt == 1){
                        geldsack = Bezahlvorgang.bezahlen(geldsack, listOfProducts.get(eingabeInt - 1).getPrice());
                    }
                    else{
                        chooseSnack();
                    }
                }
                else if(eingabeInt == 0){}
                else{
                    System.out.println("Bitte zwischen 1 und " + (listOfProducts.size() - 1) + " wählen.");
                    System.out.println("oder mit 0 zurück zum Hauptmenü navigieren,");
                }
            }
            else{
                System.out.println("Aktuell gibt es keine Produkte.");
                System.out.println("Bitte kommen sie später wieder");
            }
        } catch (NumberFormatException e) { //Catch wrong input
            System.out.println("Bitte valide Eingaben tätigen.");
        }
    }
}
