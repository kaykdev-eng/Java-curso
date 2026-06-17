package hotelService.model.entites;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Reservation {
    private Integer roomNumber;
    private LocalDate checkin;
    private LocalDate checkout;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout) {
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer duration () {
        return (int) ChronoUnit.DAYS.between(this.checkin, this.checkout);
    }

    public void updateData(LocalDate chekin, LocalDate checkout) {
        this.checkin = chekin;
        this.checkout = checkout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Room: ");
        sb.append(getRoomNumber());
        sb.append(", check-in: ");
        sb.append(sdf.format(checkin));
        sb.append(", check-out: ");
        sb.append(sdf.format(checkout));
        sb.append(", ");
        sb.append(duration());
        sb.append(" nights");
        return sb.toString();
    }
}
