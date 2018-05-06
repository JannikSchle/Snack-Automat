package Coins;

/**
 * Created by Jannik on 24.04.2018.
 */
public class Euro2 extends Coin {

    private final int wert;
    private String bez;

    public Euro2(int menge) {
        super(menge);
        this.wert = 200;
        this.bez = "2,00€";
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
