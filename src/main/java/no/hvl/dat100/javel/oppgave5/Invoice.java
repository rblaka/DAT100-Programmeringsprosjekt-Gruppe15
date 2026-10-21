package no.hvl.dat100.javel.oppgave5;

import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave2.MonthlyPower;
import no.hvl.dat100.javel.oppgave3.PowerAgreementType;

import java.util.Arrays;

//Klasse som brukes for å skrive ut invoice for en kunde. Har sammenheng med månedlig strømregning og kunde objektene.

public class Invoice {

    private Customer c; // customer associated with this invoice
    private String month; // month that the invoice covers
    private double[][] usage; // power usage this month (per day and per hour)
    private double[][] prices; // power prices for this month
    private double amount; // power price for this month


    //Konstruktør
    public Invoice(Customer c, String month, double[][] usage, double[][] power_prices) {

        this.c = c;
        this.month = month;
        this.usage = usage;
        prices = power_prices;
        amount = 0;

    }

    //Utifra hvilken strømavtale kunden har, beregnes månedlig strømpris deretter.
    public void computeAmount() {
        switch(c.getAgreement())
        {
            case PowerAgreementType.NORGESPRICE:
                amount = MonthlyPower.computeNorgesPrice(usage);
                break;
            case PowerAgreementType.SPOTPRICE:
                amount = MonthlyPower.computeSpotPrice(usage, prices);
                break;
            case PowerAgreementType.POWERSUPPORT:
                amount = MonthlyPower.computeSpotPrice(usage, prices) - MonthlyPower.computePowerSupport(usage, prices);
                break;
        }

    }

    //Er formatert til å skrive ut kunderegningene for en spesifikk kunde.
    public String toString(){
        computeAmount();
        String amountTrunk = String.format("%.2f", amount);//Trimmer bort decimalene til to plasser
        String usageTrunk = String.format("%.2f", MonthlyPower.computePowerUsage(usage)); //Trimmer bort decimalene til to plasser
        String output =
                "Month: " + month + "\r\n" +
                "Usage: " + usageTrunk  + " kwh" + "\r\n" +
                "Amount: " + amountTrunk + " kr";
        return output;
    }

    //Metode som printer ut navn, epost, osv fra kundeobjektet c, og selve regningen fra invoice-objektet -this.
    public void printInvoice() {
        System.out.println(c.toString());
        System.out.println();
        System.out.println(this.toString());
    }
}
