package Coins;

/**
 * Created by Jannik on 24.04.2018.
 */
public class Cent20 extends Coin {

    private final int wert;
    private String bez;

    public Cent20(int menge) {
        super(menge);
        this.wert = 20;
        this.bez = "0,20€";
    }
    @Override
    public String getBez() {
        return bez;
    }

    @Override
    public int getWert() {
        return wert;
    }
}
