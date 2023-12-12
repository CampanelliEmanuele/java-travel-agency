package vacanza;

import java.time.Duration;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 2, 1);


        Vacanza v = new Vacanza("destination", startDate, endDate);

        System.out.println(v.getHolidayDuration());
    }
}

