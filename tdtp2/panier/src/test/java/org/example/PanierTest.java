package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class PanierTest {
    GestionDeStock gest;
    Comptabilite compta;
    Panier panier;

    @BeforeAll
    void beforeAll() {
        gest = new GestionDeStock("");
        compta = new Comptabilite("");
        panier = new Panier(gest, compta);
    }

    @Test
    void declencherCommande() {
        panier.declencherCommande();

        assertThat(compta.traite(panier.getContenu())).isEqualTo("comptabilité:contenu du panier");
        assertThat(gest.traite(panier.getContenu())).isEqualTo("G.DES.STOCKS:CONTENU DU PANIER");
    }

    @Test
    void getContenu() {
        String res = panier.getContenu();

        assertThat(res).isEqualTo("Contenu du panier");
    }
}