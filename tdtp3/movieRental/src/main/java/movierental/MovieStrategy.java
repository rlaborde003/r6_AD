package movierental;

public interface MovieStrategy {
    public final double BASE = 1.5;

    double getAmount(Rental each, double thisAmount);
    boolean isSameCode(int priceCode);
}
