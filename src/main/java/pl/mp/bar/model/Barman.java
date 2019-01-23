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

    public Barman(Bar bar) {
        this.bar = bar;
    }

    public void run() {
        while (!Thread.interrupted()) {
            try {
                bar.putDrink();
                Thread.sleep(1000);
            } catch (InterruptedException ex){
                log.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
    }

}
