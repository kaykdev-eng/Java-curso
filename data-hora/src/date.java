import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class date {
    static void main(String[] args) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());

        LocalDate d01 = LocalDate.now();
        LocalDateTime d02 = LocalDateTime.now();
        Instant d03 = Instant.now();
        LocalDate d04 = LocalDate.parse("2026-06-03");
        Instant d05 = Instant.parse("2026-06-03T23:05:34-03:00");
        LocalDate d06 = LocalDate.parse("03/06/2026", fmt);
        LocalDate d07 = LocalDate.of(2026, 6, 3);
        LocalDateTime d08 = LocalDateTime.of(2026, 6, 3, 20, 52 );

        System.out.println("d01 = " + d01.format(fmt));
        System.out.println("d02 = " + d02);
        System.out.println("d03 = " + d03);
        System.out.println("d04 = " + d04);
        System.out.println("d05 = " + d05);
        System.out.println("d06 = " + d06);
        System.out.println("d07 = " + d07);
        System.out.println("d08 = " + d08);
        System.out.println("d01 = " + d01.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("d02 = " + d02.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        System.out.println("d03 = " + d03);
        System.out.println("d03 = " + fmt2.format(d03));
    }
}
