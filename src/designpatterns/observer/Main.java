package designpatterns.observer;

public class Main {
    public static void main(String[] args) {
        Taxi t1 = new Taxi(1,"1-QBZ-212","DIESEL",2.50);
        Taxi t2 = new Taxi(2,"1-ABC-459","ESSENCE",3.50);
        Client c1 = new Client(1,"bilal.azizi@gmail.com","Azizi","Bilal","0123456789");
        Client c2 = new Client(2,"zakaria.azizi@gmail.com","Azizi","Zakaria","0444444444");

        t1.addObserver(c1);
        t1.addObserver(c2);
        t2.addObserver(c1);

        t1.setPrixKm(1.50);
        t2.setPrixKm(4.50);
    }
}

