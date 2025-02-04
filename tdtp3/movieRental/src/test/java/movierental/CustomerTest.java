package movierental;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CustomerTest {

    @Test
    public void test_si_statement_renvoie_la_chaine_attendue() {
        // Given
        Customer customer = new Customer("Bob");
        Movie jaws = mock(Movie.class);
        when(jaws.getTitle()).thenReturn("Jaws");
        when(jaws.getPriceCode()).thenReturn(Movie.REGULAR);

        Rental one = mock(Rental.class);
        when(one.getMovie()).thenReturn(jaws);
        when(one.getDaysRented()).thenReturn(2);

        customer.addRental(one);

        // When
        String res = customer.statement();
        String expected = "" +
                "Rental Record for Bob\n" +
                "\tJaws\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points";

        // Then
        assertThat(res).isEqualTo(expected);
    }

    @Test
    void test_si_ajout_location_fonctionne() {
        // Given
        Customer customer = new Customer("Bob");
        Movie jaws = mock(Movie.class);
        when(jaws.getTitle()).thenReturn("Jaws");
        when(jaws.getPriceCode()).thenReturn(Movie.REGULAR);

        Rental one = mock(Rental.class);
        when(one.getMovie()).thenReturn(jaws);
        when(one.getDaysRented()).thenReturn(2);

        // When

        // Then
    }
}