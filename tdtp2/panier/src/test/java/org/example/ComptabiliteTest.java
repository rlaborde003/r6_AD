package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComptabiliteTest {

    @Test
    void traite_commande_iphone15() {
        Comptabilite compta = new Comptabilite("");

        String res = compta.traite("Iphone 16");

        assertThat(res).isEqualTo("comptabilité:iphone 16");
    }
}