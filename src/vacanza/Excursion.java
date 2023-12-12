package vacanza;

public class Excursion {
    private String city;
    private int duration;
    private double price;

    public Excursion(String city, int duration) throws IllegalArgumentException {
        if (validCity(city)) {
            this.city = city;
        } else {
            throw new IllegalArgumentException("ERROR: Inserire una città valida.");
        }

        if (validDuration(duration)) {
            this.duration = duration;
        } else {
            throw new IllegalArgumentException("ERROR: Inserire una durata compresa tra le 1 e le 8 ore.");
        }

        this.price = 15 * duration;
    }

    /* GETTERS AND SETTERS */

    private boolean validCity(String city) {
        return city != null && city.length() >= 2;
    }

    private boolean validDuration(int duration) {
        return duration >= 1 && duration <= 8;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if (validCity(city))
            this.city = city;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        if (validDuration(duration))
            this.duration = duration;
    }

    public double getPrice() {
        return price;
    }
}
