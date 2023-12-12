package vacanza;

import java.time.LocalDate;
import java.util.ArrayList;

import static java.time.temporal.ChronoUnit.DAYS;

public class Holiday {

    private String destination;
    private LocalDate startDate;
    private LocalDate finalDate;
    private ArrayList<Excursion> excursionsList;

    public Holiday(String destination, LocalDate startDate, LocalDate finalDate) throws IllegalArgumentException {
        validDestination(destination);
        this.destination = destination;
        validStartDate(startDate);
        this.startDate = startDate;
        validFinalDate(finalDate, startDate);
        this.finalDate = finalDate;
    }

    /* EXERCISE FUNCTIONS */

    public long getHolidayDuration() {
        return DAYS.between(startDate, finalDate);
    }

    @Override
    public String toString() {
        return "Hai prenotato una vacanza di " + getHolidayDuration() +
                " giorni a " + destination +
                " dal " + startDate +
                " al " + finalDate;
    }

    /* BONUS */
    public double getExcursionsPrice() {
        double totalPrice = 0d;
        for (Excursion excursion : excursionsList)
            totalPrice += excursion.getPrice();
        return totalPrice;
    }

    /* VALIDATORS */

    private void validDestination(String destination) {
        if (destination == null || destination.isEmpty())
            throw new IllegalArgumentException("ERROR: invalid destination.");
    }

    private void validStartDate(LocalDate startDate) {
        if (startDate.isBefore(LocalDate.now()))
            throw new IllegalArgumentException("ERROR: invalid  startDate.");
    }

    private void validFinalDate(LocalDate finalDate, LocalDate startDate) {
        if (finalDate.isBefore(startDate))
            throw new IllegalArgumentException("ERROR: invalid finalDate.");
    }

    /* GETTERS AND SETTERS */

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        validDestination(destination);
        this.destination = destination;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        validStartDate(startDate);
        this.startDate = startDate;
    }

    public LocalDate getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(LocalDate finalDate) {
        validFinalDate(finalDate, startDate);
        this.finalDate = finalDate;
    }

    public ArrayList<Excursion> getExcursionsList() {
        return excursionsList;
    }

    public void setExcursionsList(ArrayList<Excursion> excursionsList) {
        if (!excursionsList.isEmpty())
            this.excursionsList = excursionsList;
    }
}
