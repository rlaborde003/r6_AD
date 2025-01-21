import java.time.LocalDate;

public class SimpleClassV2 {

    public SimpleClassV2() {
    }

    /**
     * Additionne a et b
     * @param a - premier paramètre
     * @param b - second paramètre
     * @return
     */
    public int someAdditionMethodV2(int a, int b) {
        return a + b ;
    }


    public static boolean isDateOutside(LocalDate date, LocalDate startingDate, LocalDate endingDate) {
        return !DateUtils.isNowBetween(date, startingDate, endingDate);
    }

    public static void main(String[] args) {
        new SimpleClassV2().someAdditionMethodV2(1,2);

        System.out.println("Hello world");
    }
}


