package no.hvl.dat100.javel.oppgave2;

import no.hvl.dat100.javel.oppgave1.DailyPower;

/*Denne klassen er laget for å knytte daglig strømforbruk sammen med månedlig forbruk,
 som brukes til å beregne forbruk og kostnad for kunde-objektet.*/

public class MonthlyPower {

    // a) print power usage for a month
    /*Bruker for-løkke for å gå igjennom listen usage[] for å gå igjennom måneden,
    gjenbruker så metode printPowerUsage i Dailypower for å printe ut kwh fra hvert enkelt element i listen.*/
    public static void print_PowerUsage(double[][] usage) {
        //Kaller metoden printPowerUsage() fra oppgave 1
        for(int i = 0; i < usage.length; i++){
            System.out.printf("Day" + (i+1) + ":");
            DailyPower.printPowerUsage(usage[i]);
            System.out.println();
        }
    }

    // b) print power prices for a month
    /*Bruker for-løkke for å gå igjennom listen prices[] for å gå igjennom måneden,
    gjenbruker så metode printPowerUsage i Dailypower for å printe ut pris fra hvert enkelt element i listen.*/
    public static void print_PowerPrices(double[][] prices) {
        //Kaller metoden printPowerPrices() fra oppgave 1
        for(int i = 0; i < prices.length; i++){
            System.out.printf("Day" + (i+1) + ":");
            DailyPower.printPowerPrices(prices[i]);
            System.out.println();

        }

    }

    // c) compute total power usage for a month
    //Kaller metoden computePowerUsage() fra oppgave 1
    public static double computePowerUsage(double[][] usage) {

        double sum = 0;

        for(int i = 0; i < usage.length; i++){
            sum += DailyPower.computePowerUsage(usage[i]);
        }
        return sum;
    }

    // d) determine whether a given threshold in powerusage for the month has been exceeded
    public static boolean exceedThreshold(double[][] powerusage, double threshold) {

        boolean exceeded = false;
        double usage = 0;

        int i = 0;
        int j = 0;
        //Bruker en while-løkke for å kunne stoppe løkken når man har funnet ett element som er over grenseverdi.
        while(!exceeded){
            usage += powerusage[i][j];
            //Hvis ett element er funnet over grenseverdi, gå ut av løkke.
            if(usage > threshold){
                exceeded = true;

            }
            //Hvis timene i døgnet ikke er makset ut, inkrementer time.
            else if( j < powerusage[i].length-1){
                j++;
            }
            //Hvis timene i dagen makset ut, inkrementer dagen, sett timetall til null
            else{
                i++;
                j = 0;
            }
            //Hvis man kommer til slutten av måneden, altså siste dag. og siste time. avslutt søk og avslutt løkke.
            if(i >= powerusage.length){
                break;
            }
        }
        return exceeded;
    }

    // e) compute spot price
    //Her gjøres mye av det samme som i oppgave 1, men kaller metoden computeSpotPrice() fra oppgave 1 for å gjenbruke kode.
    public static double computeSpotPrice(double[][] usage, double[][] prices) {

        double price = 0;
        for(int i = 0; i < usage.length; i++){
            price += DailyPower.computeSpotPrice(usage[i], prices[i]);
        }

        return price;
    }

    // f) power support for the month
    //Her gjøres mye av det samme som i oppgave 1, men kaller metoden computePowerSupport() fra oppgave 1 for å gjenbruke kode.
    public static double computePowerSupport(double[][] usage, double[][] prices) {

        double support = 0;
        for(int i = 0; i < usage.length; i++){
            support += DailyPower.computePowerSupport(usage[i], prices[i]);
        }
        return support;
    }

    // g) Norgesprice for the month
    //Her gjøres mye av det samme som i oppgave 1, men kaller metoden computeNorgesPrice() fra oppgave 1 for å gjenbruke kode.
    public static double computeNorgesPrice(double[][] usage) {

        double price = 0;

        for(int i = 0; i < usage.length; i++){
            price += DailyPower.computeNorgesPrice(usage[i]);
        }

        return price;
    }
}
