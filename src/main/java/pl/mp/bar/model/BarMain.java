package pl.mp.bar.model;

public class BarMain {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Bar bar = new Bar();

        System.out.println("Start");

        Barman barman = new Barman(bar);
        Client client1 = new Client("Geralt", bar);
        Client client2 = new Client("Yennefer", bar);
        Client client3 = new Client("Ciri", bar);
        Client client4= new Client("Dandelion", bar);
        Client client5 = new Client("Zoltan", bar);

        new Thread(barman).start();
        new Thread(client1).start();
        new Thread(client2).start();
        new Thread(client3).start();
        new Thread(client4).start();
        new Thread(client5).start();

        System.out.println("The end");

    }
}
