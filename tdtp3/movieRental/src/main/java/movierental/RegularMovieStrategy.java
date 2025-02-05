package movierental;

public class RegularMovieStrategy implements MovieStrategy {
    private final static double DAYS_LIMIT = 2;

    @Override
    public double getAmount(Rental each, double thisAmount) {
        thisAmount += DAYS_LIMIT;
        if (each.getDaysRented() > DAYS_LIMIT)
            thisAmount += (each.getDaysRented() - DAYS_LIMIT) * BASE;
        return thisAmount;
    }

    @Override
    public boolean isSameCode(int priceCode) {
        return Movie.REGULAR == priceCode;
    }
}