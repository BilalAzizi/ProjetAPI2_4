package designpatterns.composite;

import java.util.HashSet;
import java.util.Set;

public class Categorie extends Element {
    private String nom;
    private Set<Element> elements = new HashSet<>();

    public Categorie(int id, String nom) {
        super(id);
        this.nom = nom;
    }

    public void addElement(Element element) {
        elements.add(element);
    }

    public void addElements(Element... elements) {
        for (Element element : elements) {
            this.elements.add(element);
        }
    }

    public void removeElement(Element element) {
        elements.remove(element);
    }

    public Set<Element> getElements() {
        return elements;
    }

    @Override
    public int nbreVehicule() {
        int total = 0;
        for (Element element : elements) {
            total += element.nbreVehicule();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(getId() + " - " + nom + "\n");
        for (Element element : elements) {
            sb.append(element.toString()).append("\n");
        }
        sb.append("=> Nombre total de véhicules dans ").append(nom).append(" = ").append(nbreVehicule()).append("\n");
        return sb.toString();
    }
}

