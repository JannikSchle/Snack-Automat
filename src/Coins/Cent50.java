package Coins;

/**
 * Created by Jannik on 24.04.2018.
 */
public class Cent50 extends Coin {

    private final int wert;
    private String bez;

    public Cent50(int menge) {
        super(menge);
        this.wert = 50;
        this.bez = "0,50€";
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
