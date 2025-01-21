import java.time.LocalDate;

public class DateUtils {
    public static boolean isNowBetween2(LocalDate startingDate, LocalDate endingDate) {
        LocalDate now = LocalDate.now();
        return now.isAfter(startingDate)
                &&
                now.isBefore(endingDate);
    }

    private static boolean isDateBetween(LocalDate startingDate, LocalDate endingDate, LocalDate now) {
        return now.isAfter(startingDate)
                &&
                now.isBefore(endingDate);
    }
}