package movierental;

public class ChildrenMovieStrategy implements MovieStrategy {
    private final static double DAYS_LIMIT = 3;

    @Override
    public double getAmount(Rental each, double thisAmount) {
        thisAmount += BASE;
        if (each.getDaysRented() > DAYS_LIMIT)
            thisAmount += (each.getDaysRented() - DAYS_LIMIT) * BASE;
        return thisAmount;
    }

    @Override
    public boolean isSameCode(int priceCode) {
        return Movie.CHILDRENS == priceCode;
    }
}