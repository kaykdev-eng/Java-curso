import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class date_3 {
    static void main(String[] args) {
        LocalDate d04 = LocalDate.parse("2026-06-03");
        LocalDateTime d05 = LocalDateTime.parse("2026-06-04T01:30:26");
        Instant d06 = Instant.parse("2026-06-04T01:30:26Z");

        LocalDate pastWeek = d04.minusDays(7);
        LocalDate pastWeek_2 = d04.minusWeeks(1);
        LocalDate nextWeek = d04.plusWeeks(1);
        System.out.println(pastWeek);
        System.out.println(pastWeek_2);
        System.out.println(nextWeek);

        Instant pastWeekInstant = d06.minus(7, ChronoUnit.DAYS);
        Instant nextWeekInstant = d06.plus(7, ChronoUnit.DAYS);

        System.out.println(pastWeekInstant);
        System.out.println(nextWeekInstant);

        Duration d1 = Duration.between(pastWeekInstant, nextWeekInstant);
        Duration d2 = Duration.between(pastWeek.atStartOfDay(), d04.atStartOfDay());
        System.out.println(d1);
        System.out.println(d1.toDays());
        System.out.println(d1.toMinutes());
        System.out.println(d2);
        System.out.println(d2.toDays());
    }
}
