package designpatterns.composite;

public class Main {
    public static void main(String[] args) {
        Taxi t1 = new Taxi(1, "1-ABC-123", 4, 2.50);
        Taxi t2 = new Taxi(2, "1-ABC-456", 4, 3.50);
        Taxi t3 = new Taxi(3, "2-ABC-123", 2, 1);
        Taxi t4 = new Taxi(4, "2-ABC-456", 2, 6);

        Categorie c1 = new Categorie(1, "Camionette");
        Categorie c2 = new Categorie(2, "Auto");
        Categorie c3 = new Categorie(3, "MotorHome");

        c1.addElement(t1);
        c1.addElements(c2, c3);
        c2.addElement(t2);
        c2.addElement(t3);
        c3.addElement(t4);

        System.out.println(c1);
    }
}

