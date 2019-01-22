package pl.mp.bar.model;

/**
 * Bar representation.
 */
public class Bar {
    /**
     * Drink from the bar.
     */
    private String drink;


    public synchronized void takeDrink() throws InterruptedException{
        while (drink.equals(null)){
            wait();
        }
        this.drink = null;
    }

    public synchronized void putDrink(String drink) {
        this.drink = drink;
        notifyAll();
    }
}
