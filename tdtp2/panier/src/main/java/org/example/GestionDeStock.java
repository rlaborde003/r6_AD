package org.example;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class GestionDeStock implements Observer {
    private String gestionStock;

    public GestionDeStock(String pGestionStock) {
        this.gestionStock = pGestionStock;
    }
    public String traite(String contenu) {

        return "G.DES.STOCKS:" + contenu.toString().toUpperCase();
    }


    @Override
    public void update(Observable o, Object arg) {
        traite((String)(arg).toString());
    }
}
