package vacanza;

import java.time.LocalDate;

public class GroupHoliday extends Holiday {

    // ove inseriamo il numero di partecipanti e la fascia d’età
    private int numberOfPeople, mediumAge;

    public GroupHoliday(String destination, LocalDate startDate, LocalDate finalDate, int numberOfPeople, int mediumAge) throws IllegalArgumentException {
        super(destination, startDate, finalDate);

        if (isInRange(numberOfPeople, 2, 100)) {
            this.numberOfPeople = numberOfPeople;
        } else {
            throw new IllegalArgumentException("ERROR: Devi inserire un numero di partecipanti compreso tra 2 e 100.");
        }

        if (isInRange(mediumAge, 0, 100)) {
            this.mediumAge = mediumAge;
        } else {
            throw new IllegalArgumentException("ERROR: L'età inserita deve essere compresa tra 0 e 100.");
        }
    }

    private boolean isInRange(int parameter, int min, int max) {
        return mediumAge >= min && mediumAge <= max;
    }

    @Override
    public String toString() {
        return super.toString() +
                " per un totale di " + numberOfPeople +
                " persone, aventi un'età media di " + mediumAge +
                " anni";
    }
}
