package pl.mp.bar.model;

/**
 * Barman representation.
 */
public class Barman implements Runnable {
    /**
     * Barman's bar.
     */
    private Bar bar;

    public Barman(Bar bar) {
        this.bar = bar;
    }

    public void run() {
        while (!Thread.interrupted()) {
            String drink = bar.putDrink("Pina Colada");
        }
    }

}
