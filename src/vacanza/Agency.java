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
        ArrayList<GroupHoliday> groupHolidayList = new ArrayList<>();
        ArrayList<WeddingHoliday> weddingHolidayList = new ArrayList<>();
        ArrayList<Excursion> defaultExcursions = new ArrayList<>();

        defaultExcursions.add(new Excursion("city1", 1));
        defaultExcursions.add(new Excursion("city2", 2));
        defaultExcursions.add(new Excursion("city3", 3));
        defaultExcursions.add(new Excursion("city4", 4));

        while (!stop) {
            try {
                System.out.print("Seleziona il tipo di vacanza:\n1. Vacanza classica\n2. Vacanda in gruppo\n3. Viaggio di nozze");
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
                        holiday.setExcursionsList(defaultExcursions);
                        holidayList.add(holiday);

                        /* object print */
                        System.out.println(holiday);
                        break;
                    case 2:     // vacanza di gruppo
                        /* getting more inputs */
                        System.out.print("Inserisci il numero di partecipanti: ");
                        int numberOfPeople = Integer.parseInt(scanner.nextLine());
                        System.out.print("Inserisci l'età minima dei partecipanti: ");
                        int minAge = Integer.parseInt(scanner.nextLine());
                        System.out.print("Inserisci l'età massima dei partecipanti: ");
                        int maxAge = Integer.parseInt(scanner.nextLine());

                        /* Create a new object and add it to the list */
                        GroupHoliday groupHoliday = new GroupHoliday(destination, startDate, endDate, numberOfPeople, minAge, maxAge);
                        groupHoliday.setExcursionsList(defaultExcursions);
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
                        weddingHoliday.setExcursionsList(defaultExcursions);
                        weddingHolidayList.add(weddingHoliday);

                        /* object print */
                        System.out.println(weddingHoliday);
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } finally {
                /* stop check */
                System.out.println("Premere Y per inserire una nuova vacanza:\t");
                String canStop = scanner.nextLine();
                if (!canStop.equalsIgnoreCase("Y")) {
                    stop = true;
                }
            }
        }

        /* Print the total price of all excursions */
        double totalExcursionPrice = 0;
        for (Excursion excursion : defaultExcursions)
            totalExcursionPrice += excursion.getPrice();
        System.out.println("Il prezzo totale della lista di escursioni ammonta a: " + totalExcursionPrice);

        /* Print the total price of all excursions of all holidays */
        totalExcursionPrice = 0;
        for (Holiday holiday : holidayList)
            totalExcursionPrice += holiday.getExcursionsPrice();

        for (GroupHoliday groupHoliday : groupHolidayList)
            totalExcursionPrice += groupHoliday.getExcursionsPrice();

        for (WeddingHoliday weddingHoliday : weddingHolidayList)
            totalExcursionPrice += weddingHoliday.getExcursionsPrice();

        System.out.println("Il prezzo totale di tutte le escursioni di ogni vacanza inserita ammonta a: " + totalExcursionPrice);
    }
}

