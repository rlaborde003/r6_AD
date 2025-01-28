package org.example;

public class ChildFeeStrategy implements FeeStrategy {
    static final double CHILD_PRICE_BASE = 100;

    @Override
    public double calculate(TicketType ticketType) {
        double fee = 0; // ticket price
        if (TicketType.HALF_DAY == ticketType) {
            fee = CHILD_PRICE_BASE * 0.2;
        } else if (TicketType.FULL_DAY == ticketType) {
            fee = CHILD_PRICE_BASE * 0.5;
        }
        return fee;
    }

    @Override
    public boolean accepts(Visitor visitor) {
        return visitor.getAge() <= 14;
    }
}