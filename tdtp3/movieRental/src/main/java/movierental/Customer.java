package movierental;

import java.util.ArrayList;
import java.util.List;

enum Movie {
    NEW_RELEASE, REGULAR, CHILDRENS
}

public class Customer {

    private static List<MovieStrategy> strategies = List.of (
            new ChildrenMovieStrategy(),
            new NewReleaseMovieStrategy(),
            new RegularMovieStrategy()
    );

    private String _name;
    private List<Rental> _rentals = new ArrayList<Rental>();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        MovieStrategy strategy;
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";

        for (Rental each : _rentals) {
            double thisAmount = 0;

            int cpteurStrategies = 0; // 1 seule stratégie doit être trouvée
            int i = 0;
            // Recherche de l'unique stratégie qui convient au visitor concerné = parcours complet, en comptant les stratégies trouvées
            // Attention : si plusieurs stratégies sont valides, exception
            while (i < strategies.size()) {
                strategy = strategies.get(i);
                if (strategy.isSameCode(each.getMovie().getPriceCode())) {                 // si stratégie convient
                    thisAmount = strategy.getAmount(each, thisAmount);       // appliquer le tarif correspondant
                    cpteurStrategies++;
                }
                i++;
            }
            if (cpteurStrategies != 1) { throw new IllegalStateException(); }

            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
                frequentRenterPoints++;

            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";

        return result;
    }

}
