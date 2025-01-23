package org.example;

public class FeeCalculator {
    private static final double CHILD_PRICE_BASE = 100;
    private static final double ADULT_PRICE_BASE = 100;

    public static double calculateFee(TicketType ticketType) {
        double fee = 0;

        // calculate price for adults
        fee = calculateAdultFee(ticketType);

        // calculate price for children
        fee = calculateChildrenFee(ticketType);
        return fee;
    }

    private static double calculateChildrenFee(TicketType ticketType) {
        double fee = 0; // ticket price
        if (TicketType.HALF_DAY == ticketType) {
            fee = CHILD_PRICE_BASE * 0.2;
        } else if (TicketType.FULL_DAY == ticketType) {
            fee = CHILD_PRICE_BASE * 0.5;
        }
        return fee;
    }

    private static double calculateAdultFee(TicketType ticketType) {
        double fee = 0; // ticket price
        if (TicketType.HALF_DAY == ticketType) {
            fee = ADULT_PRICE_BASE * 0.6;
        } else if (TicketType.FULL_DAY == ticketType) {
            fee = ADULT_PRICE_BASE * 1.2;
        }
        return fee;
    }
}
