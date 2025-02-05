package movierental;

public class NewReleaseMovieStrategy implements MovieStrategy {
    private final static double NEW_RELEASE_BASE = 3;

    @Override
    public double getAmount(Rental each, double thisAmount) {
        thisAmount += each.getDaysRented() * NEW_RELEASE_BASE;
        return thisAmount;
    }

    @Override
    public boolean isSameCode(int priceCode) {
        return Movie.NEW_RELEASE == priceCode;
    }
}

public static final int CHILDRENS = 2;

public static final int REGULAR = 0;