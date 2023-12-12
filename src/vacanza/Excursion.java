package vacanza;

public class Excursion {
    private String city;
    private int duration;
    private final double price;

    public Excursion(String city, int duration) throws IllegalArgumentException {
        validCity(city);
        this.city = city;

        validDuration(duration);
        this.duration = duration;

        this.price = 15 * duration;
    }

    /* VALIDATORS */

    private void validCity(String city) {
        if (city == null || city.length() <= 2)
            throw new IllegalArgumentException("ERROR: Inserire una città valida.");
    }

    private void validDuration(int duration) {
        if (duration <= 1 || duration >= 8)
            throw new IllegalArgumentException("ERROR: Inserire una durata compresa tra le 1 e le 8 ore.");
    }

    /* GETTERS AND SETTERS */

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        validCity(city);
        this.city = city;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        validDuration(duration);
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }
}
