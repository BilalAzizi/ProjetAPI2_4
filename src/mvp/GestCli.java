package mvp;

import mvp.model.*;
import mvp.presenter.AdressePresenter;
import mvp.presenter.ClientPresenter;
import mvp.presenter.LocationPresenter;
import mvp.presenter.TaxiPresenter;
import mvp.view.*;

import java.util.Arrays;
import java.util.List;

import static utilitaires.Utilitaire.choixListe;

public class GestCli {
    private DAOClient cm;
    private ClientViewInterface cv;
    private ClientPresenter cp;

    private DAOAdresse am;
    private AdresseViewInterface av;
    private AdressePresenter ap;

    private DAOLocation lm;
    private LocationViewInterface lv;
    private LocationPresenter lp;

    private DAOTaxi tm;
    private TaxiViewInterface tv;
    private TaxiPresenter tp;

    public void gestion() {

        cm = new ClientModelDB();
        //cm = new ClientModel();
        cv = new ClientViewConsole();
        //cv = new ClientViewGraph();
        cp = new ClientPresenter(cm,cv);

        am = new AdresseModelDB();
        av = new AdresseViewConsole();
        ap = new AdressePresenter(am,av);

        tm = new TaxiModelDB();
        tv = new TaxiViewConsole();
        tp = new TaxiPresenter(tm,tv);

        lm = new LocationModelDB();
        lv = new LocationViewConsole();
        lp = new LocationPresenter(lm,lv);
        lp.setClientPresenter(cp);
        lp.setAdressePresenter(ap);
        lp.setTaxiPresenter(tp);

        List<String> options = Arrays.asList("Client","Adresse","Location","Taxi","Fin");
        do {
            int ch = choixListe(options);
            switch (ch) {
                case 1: cp.start();
                    break;
                case 2: ap.start();
                    break;
                case 3: lp.start();
                    break;
                case 4: tp.start();
                    break;
                case 5:
                    System.exit(0);
            }
        } while (true);
    }

    public static void main(String[] args) {
        GestCli g = new GestCli();
        g.gestion();
    }
}
