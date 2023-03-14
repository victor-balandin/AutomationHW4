import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MinimalDataDelivery {

    public String minDataDelivery() {
        LocalDate date = LocalDate.now();
        date = date.plusDays(3);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String minDate = date.format(formatter);
        return minDate;

    }


}
