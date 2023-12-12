package vacanza;

import java.time.LocalDate;

public class GroupHoliday extends Holiday {
    private int numberOfPeople, minAge, maxAge;

    public GroupHoliday(String destination, LocalDate startDate, LocalDate finalDate, int numberOfPeople, int minAge, int maxAge) throws IllegalArgumentException {
        super(destination, startDate, finalDate);
        isInRange(numberOfPeople, 2, 100);
        this.numberOfPeople = numberOfPeople;

        isInRange(minAge, 0, maxAge);
        this.minAge = minAge;

        isInRange(maxAge, minAge, 100);
        this.maxAge = maxAge;
    }

    @Override
    public String toString() {
        return super.toString() +
                " per un totale di " + numberOfPeople +
                " persone, aventi un'età compresa tra i " + minAge +
                " e i " + maxAge +
                " anni";
    }

    /* VALIDATORS */

    private void isInRange(int parameter, int min, int max) {
        if (parameter <= min || parameter >= max)
            throw new IllegalArgumentException("ERROR: " + parameter + " non è compreso tra " + min + " e " + max);
    }

    /* GETTERS AND SETTERS */

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        isInRange(numberOfPeople, 2, 100);
        this.numberOfPeople = numberOfPeople;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        isInRange(minAge, 0, maxAge);
        this.minAge = minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        isInRange(maxAge, minAge, 100);
        this.maxAge = maxAge;
    }
}
