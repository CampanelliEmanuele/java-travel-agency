package vacanza;

import java.time.LocalDate;
import java.util.Scanner;

public class Agency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean stop = false;

        while (!stop) {

            /* Get destination */
            System.out.println("Inserimento dati per una nuova vacanza");
            System.out.println("Inserire la destinazione: ");
            String destination = scanner.nextLine();

            /* Get startDate */
            System.out.print("Inserire la data di inizio nel formato yyyy-mm-dd: ");
            String inputDate = scanner.nextLine();
            LocalDate startDate = LocalDate.parse(inputDate);

            /* Get finalDate */
            System.out.print("Inserire la data di fine nel formato yyyy-mm-dd: ");
            inputDate = scanner.nextLine();
            LocalDate endDate = LocalDate.parse(inputDate);

            /* Create a new object */
            Holiday v = new Holiday(destination, startDate, endDate);
            System.out.println("Tutti i dati inseriti sono corretti, ho creato l'oggetto");

            /* object print */
            System.out.println(v.toString());

            /* stop check */
            System.out.println("Premere Y per inserire una nuova vacanza:\t");
            String canStop = scanner.nextLine();
            if (!canStop.equalsIgnoreCase("Y")) {
                stop = true;
            }
        }

    }
}

