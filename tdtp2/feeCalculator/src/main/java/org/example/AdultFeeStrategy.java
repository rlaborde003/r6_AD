package org.example;

public class AdultFeeStrategy implements FeeStrategy {
    static final double ADULT_PRICE_BASE = 100;

    public double calculate(TicketType ticketType) {
        double fee = 0; // ticket price
        if (TicketType.HALF_DAY == ticketType) {
            fee = ADULT_PRICE_BASE * 0.6;
        } else if (TicketType.FULL_DAY == ticketType) {
            fee = ADULT_PRICE_BASE * 1.2;
        }
        return fee;
    }

    @Override
    public boolean accepts(Visitor visitor) {
        return visitor.getAge() > 14;
    }
}