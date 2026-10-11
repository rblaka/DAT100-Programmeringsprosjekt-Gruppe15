package no.hvl.dat100.javel.oppgave1;

import no.hvl.dat100.javel.oppgave2.MonthlyPower;

public class DayMain {

    public static void main(String[] args) {

        // test data
        double[] powerusage_day = DayPowerData.powerusage_day;

        double[] powerprices_day = DayPowerData.powerprices_day;

        System.out.println("==============");
        System.out.println("OPPGAVE 1");
        System.out.println("==============");
        System.out.println();

        //Test av metoder:
        DailyPower.printPowerPrices(powerprices_day); //Test av oppgave 1 a)
        System.out.println();
        DailyPower.printPowerUsage(powerusage_day); //Test av oppgave 1 b)
        System.out.println();
        System.out.printf("strømforbruk 24-timer: " + "%.2f kwh ", + DailyPower.computePowerUsage(powerusage_day)); //Test av oppgave 1 c)
        System.out.println();
        System.out.printf("Spotpris for 24-timer: " + "%.2f kr ", + DailyPower.computeSpotPrice(powerusage_day, powerprices_day)); //Test av oppgave 1 d)
        System.out.println();
        System.out.printf("Strømstøtte for 24-timer: " + "%.2f kr ", + DailyPower.computePowerSupport(powerusage_day, powerprices_day)); //Test av Oppgave e) og  f)
        System.out.println();
        System.out.printf("Norgespris for 24-timer: " + "%.2f kr ", + DailyPower.computeNorgesPrice(powerusage_day)); //Test av Oppgave g)
        System.out.println();
        System.out.printf("Peakforbruk ila 24-timer: " + "%.2f kwh ", + DailyPower.findPeakUsage(powerusage_day)); //Test av Oppgave h)
        System.out.println();
        System.out.printf("Gjennomsnittsforbruk 24-timer: " + "%.2f kwh ", + DailyPower.findAvgPower(powerusage_day)); //Test av Oppgave j)
    }
}
