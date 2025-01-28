package org.example;
import java.util.List;
public class FeeCalculator {

    private static List<FeeStrategy> strategies = List.of(new ChildFeeStrategy(), new AdultFeeStrategy());

    public static double calculateFee(Visitor visitor, TicketType ticketType) {
        double fee = 0.0;
        FeeStrategy strategy;
        int i = 0;
        boolean trouve = false;

        while(true) {
            if (i == strategies.size()) { break; }
            strategy = strategies.get(i);
            if (strategy.accepts(visitor)) {
                trouve = true;
                break;
            }
            i ++;
        }

        if (trouve) {
            fee = strategy.calculate(ticketType);
        }

        return fee;
    }

}
