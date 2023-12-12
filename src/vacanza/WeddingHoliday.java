package vacanza;

import java.time.LocalDate;
import java.util.ArrayList;

public class WeddingHoliday extends Holiday {

    ArrayList<String> treatments;

    public WeddingHoliday(String destination, LocalDate startDate, LocalDate finalDate, ArrayList<String> treatments) throws IllegalArgumentException {
        super(destination, startDate, finalDate);

        validTreatments(treatments);
        this.treatments = treatments;
    }

    @Override
    public String toString() {
        return super.toString() +
                " includente i seguenti trattamenti: " + treatments;
    }

    /* VALIDATORS */

    private void validTreatments(ArrayList<String> treatments) {
        if (treatments == null)
            throw new IllegalArgumentException("ERORR: La lista dei trattamenti inserita non è valida.");
    }

    /* GETTERS AND SETTERS */

    public ArrayList<String> getTreatments() {
        return treatments;
    }

    public void setTreatments(ArrayList<String> treatments) {
        validTreatments(treatments);
        this.treatments = treatments;
    }
}
