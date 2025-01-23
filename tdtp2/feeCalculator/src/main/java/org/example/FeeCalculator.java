package org.example;

public class FeeCalculator {

    public static double calculateFee(TicketType ticketType) {
        double fee = 0;

        // calculate price for adults
        fee = new AdultFeeStrategy().calculateAdultFee(ticketType);

        // calculate price for children
        fee = new ChildFeeStrategy().calculateChildrenFee(ticketType);
        return fee;
    }

}
