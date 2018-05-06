package Coins;

/**
 * Created by Jannik on 24.04.2018.
 */
public class Euro1 extends Coin {

    final int wert;
    final String bez;

    public Euro1(int menge) {
        super(menge);
        this.wert = 100;
        this.bez = "1,00€";
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
