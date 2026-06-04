import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class date_2 {
    static void main(String[] args) {


        LocalDate d04 = LocalDate.parse("2026-06-03");
        LocalDateTime d05 = LocalDateTime.parse("2026-06-04T01:30:26");
        Instant d06 = Instant.parse("2026-06-04T01:30:26Z");

        LocalDate r1 = LocalDate.ofInstant(d06, ZoneId.systemDefault());
        LocalDate r2 = LocalDate.ofInstant(d06, ZoneId.of("Portugal"));
        System.out.println(r1);
        System.out.println(r2);

        System.out.println("d04 dia = " + d04.getDayOfMonth());

    }
}
