package pl.mp.bar.model;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Client representation.
 */
public class Client implements Runnable {
    //new logger to log errors
    public static final Logger log = Logger.getLogger(Client.class.getCanonicalName());

    /**
     * Client name.
     */
    private String name;

    /**
     * Bar.
     */
    private Bar bar;

    public Client(String name, Bar bar) {
        this.name = name;
        this.bar = bar;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                String drink = bar.takeDrink();
                System.out.println(name + " drinks " + drink);
                int time = bar.takeDrink().length();
                Thread.sleep(time);
            } catch (InterruptedException ex) {
                log.log(Level.WARNING, ex.getMessage(), ex);
                break;
            }
        }
    }
}
