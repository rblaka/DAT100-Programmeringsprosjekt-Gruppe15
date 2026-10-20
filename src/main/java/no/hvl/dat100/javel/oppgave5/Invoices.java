package no.hvl.dat100.javel.oppgave5;

//Klasse til bruk for å skrive ut alle invoices til alle kundene. Kan være praktisk mtp årsoppgjøret til regnskapsføreren.
public class Invoices {

    //En metode for å skrive ut alle kunder sine invoices, slik at man får en total liste ove alle kundene sine regninger.
    public static void processInvoices(Invoice[] invoices) {

        for(int i = 0; i < invoices.length; i++){
            System.out.println();
            System.out.println("========================");
            invoices[i].printInvoice();
            System.out.print("========================");
            System.out.println();
        }
    }
}
