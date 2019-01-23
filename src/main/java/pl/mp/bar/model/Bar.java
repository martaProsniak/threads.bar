package pl.mp.bar.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Bar representation.
 */
public class Bar {

    /**
     * Drink from the bar.
     */

    /**
     * List with prepared drinks.
     */
    private List<String> drinkList = new ArrayList<>();

    /**
     * Gets drink and change drink field value to null.
     *
     * @return ready drink to be taken by client.
     * @throws InterruptedException
     */
    public synchronized String takeDrink() throws InterruptedException {
        while (drinkList.isEmpty()) {
            wait();
        }
        String readyDrink = drinkList.get(0);
        drinkList.remove(0);
        return readyDrink;
    }

    /**
     * Changes value of drink field.
     *
     * @param drink new value for drink field.
     */
    public synchronized void putDrink(String drink) {
        drinkList.add(drink);
        notifyAll();
    }
}

