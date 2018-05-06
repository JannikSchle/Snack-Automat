package Coins;

/**
 * Created by Jannik on 24.04.2018.
 */
public abstract class Coin {
    private int wert;
    private int menge;
    private String bez;

    public Coin(int menge) {
        this.menge = menge;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    public abstract String getBez();
    public abstract int getWert();
}
