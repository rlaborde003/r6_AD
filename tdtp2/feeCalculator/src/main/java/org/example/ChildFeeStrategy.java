package org.example;

public class ChildFeeStrategy {
    static final double CHILD_PRICE_BASE = 100;

    static double calculateChildrenFee(TicketType ticketType) {
        double fee = 0; // ticket price
        if (TicketType.HALF_DAY == ticketType) {
            fee = CHILD_PRICE_BASE * 0.2;
        } else if (TicketType.FULL_DAY == ticketType) {
            fee = CHILD_PRICE_BASE * 0.5;
        }
        return fee;
    }
}