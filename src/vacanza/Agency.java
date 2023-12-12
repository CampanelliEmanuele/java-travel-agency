package vacanza;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Agency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean stop = false;

        /* Lists of holiday types */
        ArrayList<Holiday> holidayList = new ArrayList<>();
        ArrayList<Holiday> groupHolidayList = new ArrayList<>();
        ArrayList<Holiday> weddingHolidayList = new ArrayList<>();

        while (!stop) {

            try {
                System.out.println("Seleziona il tipo di vacanza:\n1. Vacanza classica\n2. Vacanda in gruppo\n3. Viaggio di nozze");
                int holidayType = Integer.parseInt(scanner.nextLine());

                /* Get destination */
                System.out.println("Inserimento dati per una nuova vacanza");
                System.out.print("Inserire la destinazione: ");
                String destination = scanner.nextLine();

                /* Get startDate */
                System.out.print("Inserire la data di inizio nel formato yyyy-mm-dd: ");
                String inputDate = scanner.nextLine();
                LocalDate startDate = LocalDate.parse(inputDate);

                /* Get finalDate */
                System.out.print("Inserire la data di fine nel formato yyyy-mm-dd: ");
                inputDate = scanner.nextLine();
                LocalDate endDate = LocalDate.parse(inputDate);

                switch (holidayType) {
                    case 1:     // vacanza classica
                        /* Create a new object and add it to the list */
                        Holiday holiday = new Holiday(destination, startDate, endDate);
                        holidayList.add(holiday);

                        /* object print */
                        System.out.println(holiday);
                        break;
                    case 2:     // vacanza di gruppo
                        /* getting more inputs */
                        System.out.print("Inserisci il numero di partecipanti: ");
                        int numberOfPeople = Integer.parseInt(scanner.nextLine());
                        System.out.print("Inserisci l'età media dei partecipanti: ");
                        int mediumAge = Integer.parseInt(scanner.nextLine());

                        /* Create a new object and add it to the list */
                        GroupHoliday groupHoliday = new GroupHoliday(destination, startDate, endDate, numberOfPeople, mediumAge);
                        groupHolidayList.add(groupHoliday);

                        /* object print */
                        System.out.println(groupHoliday);
                        break;
                    case 3:     // viaggio di nozze
                        /* getting more inputs */
                        ArrayList<String> treatments = new ArrayList<>();
                        boolean stopTreatments = false;

                        while (!stopTreatments) {
                            System.out.print("Inserisci un trattamento extra: ");
                            treatments.add(scanner.nextLine());

                            System.out.print("Premere il tasto 'c' per inserire un altro trattamento: ");
                            String canStop = scanner.nextLine();
                            if (!canStop.equalsIgnoreCase("c")) {
                                stopTreatments = true;
                            }
                        }
                        /* Create a new object and add it to the list */
                        WeddingHoliday weddingHoliday = new WeddingHoliday(destination, startDate, endDate, treatments);

                        /* object print */
                        System.out.println(weddingHoliday);
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Uno o più dati inseriti non sono validi. Puoi riprovare nuovamente.");
            } finally {
                /* stop check */
                System.out.println("Premere Y per inserire una nuova vacanza:\t");
                String canStop = scanner.nextLine();
                if (!canStop.equalsIgnoreCase("Y")) {
                    stop = true;
                }
            }
        }
    }
}

