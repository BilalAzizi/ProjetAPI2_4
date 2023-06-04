package mvp.model;

import metier.Taxi;

import java.util.List;

public interface DAOTaxi {
    Taxi addTaxi(Taxi taxi);

    boolean removeTaxi(Taxi taxi);

    Taxi updateTaxi(Taxi taxi);

    Taxi readTaxi(int idTaxi);

    List<Taxi> getTaxis();
}
