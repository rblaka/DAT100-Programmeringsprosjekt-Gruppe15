package no.hvl.dat100.javel.oppgave2;

import no.hvl.dat100.javel.oppgave1.DailyPower;

public class MonthlyPower {

    // a) print power usage for a month
    public static void print_PowerUsage(double[][] usage) {

        for(int i = 0; i < usage.length; i++){
            System.out.printf("Day" + (i+1) + ":");
            for(int j = 0; j < usage[i].length; j++){
                System.out.printf("%.2f kwh ", usage[i][j]);
            }
            System.out.println();
        }
    }

    // b) print power prices for a month
    public static void print_PowerPrices(double[][] prices) {

        for(int i = 0; i < prices.length; i++){
            System.out.printf("Day" + (i+1) + ":");
            for(int j = 0; j < prices[i].length; j++){
                System.out.printf("%.2f kr ", prices[i][j]);
            }
            System.out.println();
        }

    }

    // c) compute total power usage for a month
    public static double computePowerUsage(double[][] usage) {

        double sum = 0;

        for(int i = 0; i < usage.length; i++){
            for(int j = 0; j < usage[i].length; j++){
                sum += usage[i][j];
            }
        }

        return sum;
    }

    // d) determine whether a given threshold in powerusage for the month has been exceeded
    public static boolean exceedThreshold(double[][] powerusage, double threshold) {

        boolean exceeded = false;
        double usage = 0;
        boolean stop = false;

        int i = 0;
        int j = 0;
        while(!stop){
            usage += powerusage[i][j];
            if(usage > threshold){
                exceeded = true;
                stop = true;
            }
            else if( j < powerusage[i].length-1){
                j++;
            }
            else{
                i++;
                j = 0;
            }
            if(i >= powerusage.length){
                stop = true;
            }
        }
        return exceeded;
    }

    // e) compute spot price
    public static double computeSpotPrice(double[][] usage, double[][] prices) {

        double price = 0;

        // TODO

        return price;
    }

    // f) power support for the month
    public static double computePowerSupport(double[][] usage, double[][] prices) {

        double support = 0;

        // TODO

        return support;
    }

    // g) Norgesprice for the month
    public static double computeNorgesPrice(double[][] usage) {

        double price = 0;

        // TODO

        return price;
    }
}
