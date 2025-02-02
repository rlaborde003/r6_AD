package org.example;

import java.util.List;
import java.util.Optional;

public class FeeCalculator {

    private static List<FeeStrategy> strategies = List.of (
            new ChildFeeStrategy(),
            new AdultFeeStrategy()
    );
    public static double calculateFee(Visitor visitor, TicketType ticketType) {
        double fee = 0;
        FeeStrategy strategy;

        int i = 0;      // indice de parcours dans la liste
        boolean trouve = false;
        int cpteurStrategies = 0; // 1 seule stratégie doit être trouvée

        // Recherche de l'unique stratégie qui convient au visitor concerné = parcours complet, en comptant les stratégies trouvées
        // Attention : si plusieurs stratégies sont valides, exception
        while (i < strategies.size()) {
            strategy = strategies.get(i);
            if (strategy.accept(visitor)) {                 // si stratégie convient
                fee = strategy.calculate(ticketType);       // appliquer le tarif correspondant
                cpteurStrategies++;
            }
            i++;
        }
        if (cpteurStrategies != 1)
        {
            throw new IllegalStateException();
        }
        return fee;
    }
}

        /*   En version améliorée : Utilisation d'un stream
            - on applique le filtre pour choisir celle(s)) qui convienent/ conviennent au visitor
            - on réduit les stratégies filtéres et on lève une exception si plusieurs stratégies ont été trouvées
            - mais il se peut que 0 stratégie ait été trouvée (Optional<FeeStrategy> strategy = = strategies.stream()  )
            - si le stream est vide, on lève une exception, sinon on retourne LA stratégie calculée  : strategy.orElseThrow...

        public static double calculateFee(Visitor visitor, TicketType ticketType) {
        double fee = 0;
        FeeStrategy strategy;

        Optional<FeeStrategy> strategy = strategies.stream()
                .filter(feeStrategy -> feeStrategy.accept(visitor))
                .reduce((feeStrategy, feeStrategy2) -> {
                    throw new IllegalStateException("There must be only one strategy for this visitor");
                });
        return strategy.orElseThrow(IllegalStateException::new).calculate(ticketType);
        }

         */
