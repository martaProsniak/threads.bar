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

    private String[] drinks = {"Thunderbolt", "Blizzard", "Swallow", "Cat", "Black blood"};

    public synchronized void takeDrink() throws InterruptedException {
        while (drink.equals(null)) {
            wait();
        }
        this.drink = null;
    }

    public synchronized void putDrink() {
        for (int i = 0; i < drinks.length; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                log.log(Level.WARNING, ex.getMessage(), ex);
            }
            this.drink = drinks[i];
            notifyAll();
        }
    }
}
