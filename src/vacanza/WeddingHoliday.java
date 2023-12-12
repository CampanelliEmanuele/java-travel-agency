package vacanza;

import java.time.LocalDate;
import java.util.ArrayList;

public class WeddingHoliday extends Holiday {

    ArrayList<String> treatments;

    public WeddingHoliday(String destination, LocalDate startDate, LocalDate finalDate, ArrayList<String> treatments) throws IllegalArgumentException {
        super(destination, startDate, finalDate);

        if (validTreatments(treatments)) {
            this.treatments = treatments;
        } else {
            throw new IllegalArgumentException("ERORR: La lista dei trattamenti inserita non è valida.");
        }
    }

    private boolean validTreatments(ArrayList<String> treatments) {
        return treatments != null;
    }

    @Override
    public String toString() {
        return super.toString() +
                " includente i seguenti trattamenti: " + treatments;
    }

    /* GETTERS AND SETTERS */

    public ArrayList<String> getTreatments() {
        return treatments;
    }

    public void setTreatments(ArrayList<String> treatments) {
        if (validTreatments(treatments))
            this.treatments = treatments;
    }
}
