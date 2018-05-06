package Coins;

/**
 * Created by Jannik on 24.04.2018.
 */
public class Cent10 extends Coin {

    private final int wert;
    private String bez;

    public Cent10(int menge) {
        super(menge);
        this.wert = 10;
        this.bez = "0,10€";
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
