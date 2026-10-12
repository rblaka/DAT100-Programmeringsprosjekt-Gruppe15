package no.hvl.dat100.javel.oppgave5;

import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave3.PowerAgreementType;
import no.hvl.dat100.javel.oppgave2.MonthPowerData;

public class InvoiceMain {

    public static void main(String[] args) {

        System.out.println("==============");
        System.out.println("OPPGAVE 5");
        System.out.println("==============");
        System.out.println();

        //Test av invoices

        //Lager nye kunder for å bruke i invoice.
        Customer kunde_Rune = new Customer("Rune", "rune@gmail.com", 1001, PowerAgreementType.NORGESPRICE);
        Customer kunde_Kata = new Customer("Kata", "kata@gmail.com", 1002, PowerAgreementType.POWERSUPPORT);
        Customer kunde_Aasmund = new Customer("Aasmund", "aasmund@gmail.com", 1003, PowerAgreementType.SPOTPRICE);

        //Legger kundene inn i invoice enkeltvis, med månedsforbruk og månedspris for bestemt måned.
        Invoice invoiceRune = new Invoice(kunde_Rune, "Januar",CustomerPowerUsageData.usage_month_customer1, MonthPowerData.powerprices_month);
        Invoice invoiceKata = new Invoice(kunde_Kata, "Januar",CustomerPowerUsageData.usage_month_customer2, MonthPowerData.powerprices_month);
        Invoice invoiceAasmund = new Invoice(kunde_Aasmund, "Januar",CustomerPowerUsageData.usage_month_customer3, MonthPowerData.powerprices_month);

        //Legger alle invoice inn i en liste, og skriver ut faktura for alle kundene.
        Invoice[] invoices = {invoiceRune, invoiceKata, invoiceAasmund};
        Invoices.processInvoices(invoices);
    }
}
