package vacanza;

public class Excursion {
    private String city;
    private int duration;
    private double price;

    public Excursion(String city, int duration) {
        if (city != null && city.length() >= 2) {
            this.city = city;
        } else {
            throw new IllegalArgumentException("ERROR: Inserire una città valida.");
        }

        if (duration >= 1 && duration <= 8) {
            this.duration = duration;
        } else {
            throw new IllegalArgumentException("ERROR: Inserire una durata compresa tra le 1 e le 8 ore.");
        }

        this.price = 15 * duration;
    }

    /* GETTERS AND SETTERS */

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }
}
