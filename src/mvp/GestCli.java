/*package mvp;

public class GestCli {
    public static void main(String[] args) {
        //DAOClient cm = new ClientModel();
         DAOClient cm = new ClientModelDB();
         ClientViewInterface cv = new ClientViewConsole();
       // ClientViewInterface cv = new ClientViewGraph();
        ClientPresenter cp = new ClientPresenter(cm,cv);//création et injection de dépendance
        cp.start();

    }
}*/