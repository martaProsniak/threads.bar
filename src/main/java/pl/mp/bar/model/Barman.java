package pl.mp.bar.model;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Barman representation.
 */
public class Barman implements Runnable {
    //new logger to log errors
    public static final Logger log = Logger.getLogger(Barman.class.getCanonicalName());
    /**
     * Barman's bar.
     */
    private Bar bar;

    /**
     * Array with available drinks.
     */
    private String[] drinks = {"Thunderbolt", "Blizzard", "Swallow", "Cat", "Black blood"};

    /**
     * Random number generator to use in run method.
     */
    private Random random = new Random();


    public Barman(Bar bar) {
        this.bar = bar;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            int i = random.nextInt(5); //random number between 0 and 4
            try {
                String drink = drinks[i];
                bar.putDrink(drink);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                log.log(Level.WARNING, ex.getMessage(), ex);
                break;
            }
        }
    }
}
