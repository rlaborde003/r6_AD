package org.example;

import org.assertj.core.api.AbstractBigDecimalAssert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class GestionDeStockTest {

    @Test
    void traite_commande_iphone16() {
        // GIVEN
        GestionDeStock gest = new GestionDeStock("");

        // WHEN
        String res = gest.traite("Iphone 15");

        // THEN
        assertThat(res).isEqualTo("G.DES.STOCKS:IPHONE 15");
    }
}