package pl.mp.bar.model;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Bar representation.
 */
public class Bar {

    private static final Logger log = Logger.getLogger(Bar.class.getCanonicalName());
    /**
     * Drink from the bar.
     */
    private String drink;

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }



    public synchronized String takeDrink() throws InterruptedException {
        while (drink == null) {
            wait();
        }
        String readyDrink = drink;
        this.drink = null;
        return readyDrink;
    }


    public synchronized void putDrink(String drink) {
            this.drink = drink;
            notifyAll();
    }
}

