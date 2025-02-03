package org.example;

import java.util.Observable;

public class Panier  {
    private final DeclenchementCommande sujet = new DeclenchementCommande();
    private GestionDeStock stock;
    private Comptabilite compta;
    private String contenu;

    public Panier (GestionDeStock pStock, Comptabilite pCompta) {
        this.stock = pStock;
        this.compta = pCompta;
        this.contenu = new String ("Contenu du panier");
    }

    public String getContenu() {
        return this.contenu;
    };

    public void declencherCommande() {
        declenchementCommande.declencherCommande();
    }

    public class DeclenchementCommande extends Observable {
        // Suppression du mot static pour pouvoir avoir un
        // accès au attributs de panier.

        private final Panier panier;

        public DeclenchementCommande(Panier panier) {
            this.panier = panier;
        }

        public void declencherCommande() {
            panier.getStock().traite(panier.getContenu());
            panier.getCompta().traite(panier.getContenu());
        }
    }
}
