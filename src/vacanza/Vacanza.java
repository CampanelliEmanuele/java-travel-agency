package vacanza;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Vacanza {

    private String destination;
    private LocalDate startDate;
    private LocalDate finalDate;

    public Vacanza(String destination, LocalDate startDate, LocalDate finalDate) throws IllegalArgumentException {
        if (validDestination(destination) && validStartDate(startDate) && validFinalDate(finalDate, startDate)) {
            this.destination = destination;
            this.startDate = startDate;
            this.finalDate = finalDate;
        } else {
            throw new IllegalArgumentException("ERROR: parametri non validi.");
        }
    }

    /* EXERCISE FUNCTIONS */

    public long getHolidayDuration() {
        return DAYS.between(startDate, finalDate);
    }

    /* VALIDATE FUNCTIONS */

    private boolean validDestination(String destination) {
        return destination != null && !destination.isEmpty();
    }

    private boolean validStartDate(LocalDate startDate) {
        return startDate.isAfter(LocalDate.now());
    }

    private boolean validFinalDate(LocalDate finalDate, LocalDate startDate) {
        return finalDate.isAfter(startDate);
    }

    /* GETTERS AND SETTERS */

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        if (validDestination(destination))
            this.destination = destination;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        if (validStartDate(startDate))
            this.startDate = startDate;
    }

    public LocalDate getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(LocalDate finalDate) {
        if (validFinalDate(finalDate, startDate))
            this.finalDate = finalDate;
    }

}
