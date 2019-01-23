package pl.mp.bar.model;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Barman representation.
 */
public class Barman implements Runnable {

    public static final Logger log = Logger.getLogger(Barman.class.getCanonicalName());
    /**
     * Barman's bar.
     */
    private Bar bar;

    private String[] drinks = {"Thunderbolt", "Blizzard", "Swallow", "Cat", "Black blood"};

    public Barman(Bar bar) {
        this.bar = bar;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            for (int i = 0; i < drinks.length; i++) {
                try {
                    bar.putDrink(drinks[i]);
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    log.log(Level.WARNING, ex.getMessage(), ex);
                }
            }
        }
    }
}
