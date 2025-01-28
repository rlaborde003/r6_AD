package org.example;

public interface FeeStrategy {

    double calculate(TicketType ticketType);
    // But : calcule et retourne le prix du ticket pour le visiteur géré par la classe

    boolean accepts(Visitor visitor);
    // But : retroune vrai si le visitor passé en paramètre est gérer par cette classe
}
