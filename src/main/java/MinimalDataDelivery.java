import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MinimalDataDelivery {
    LocalDate date = LocalDate.now();

    public String minDataDelivery() {

        date = date.plusDays(7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String minDate = date.format(formatter);
        return minDate;

    }


}
