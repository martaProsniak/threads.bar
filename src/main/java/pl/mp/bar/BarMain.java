package pl.mp.bar;

import pl.mp.bar.model.Bar;
import pl.mp.bar.model.Barman;
import pl.mp.bar.model.Client;

import java.util.Scanner;

public class BarMain {

    public static void main(String[] args) {

        barIsOpen();

    }

    /**
     * Creates barman and client threads and starts them.
     * Reads user command to end threads and programm.
     */
    private static void barIsOpen() {

        System.out.println("Busy night, but there's always room for another! \n" +
                "To leave, type: end");

        Bar bar = new Bar();

        Barman barman = new Barman(bar);
        Client client1 = new Client("Geralt", bar);
        Client client2 = new Client("Yennefer", bar);
        Client client3 = new Client("Ciri", bar);
        Client client4 = new Client("Dandelion", bar);
        Client client5 = new Client("Zoltan", bar);

        //New threads
        Thread thread1 = new Thread(barman);
        Thread thread2 = new Thread(client1);
        Thread thread3 = new Thread(client2);
        Thread thread4 = new Thread(client3);
        Thread thread5 = new Thread(client4);
        Thread thread6 = new Thread(client5);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();

        //new Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.next();
            if (command.equals("end")) {
                break;
            }
        }

        thread1.interrupt();
        thread2.interrupt();
        thread3.interrupt();
        thread4.interrupt();
        thread5.interrupt();
        thread6.interrupt();

        System.out.println("Come back tomorrow!");
    }
}
