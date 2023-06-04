package designpatterns.composite;

public abstract class Element {
    private int id;

    public Element(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public abstract int nbreVehicule();
}
