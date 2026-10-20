package no.hvl.dat100.javel.oppgave4;

import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave3.PowerAgreementType;

public class CustomersMain {

    public static void main(String[] args) {

        System.out.println("==============");
        System.out.println("OPPGAVE 4");
        System.out.println("==============");
        System.out.println();

        //Test av metoder:
        //Lager liste med plass til 5 kunder.
        Customers customers = new Customers(5);

        //Lager to kunder og legger disse til kundelisten min.
        Customer Customer_Rune = new Customer("Rune","rune@gmail.com", 1001, PowerAgreementType.NORGESPRICE);
        Customer Customer_Kata = new Customer("Kata","kata@gmail.com", 1002, PowerAgreementType.SPOTPRICE);
        Customer Customer_William = new Customer("William","William@gmail.com", 1003, PowerAgreementType.SPOTPRICE);
        Customer Customer_Oliver = new Customer("Oliver","Oliver@gmail.com", 1004, PowerAgreementType.SPOTPRICE);

        customers.addCustomer(Customer_Rune);
        customers.addCustomer(Customer_Kata);
        customers.addCustomer(Customer_William);
        customers.addCustomer(Customer_Oliver);

        //Sjekker hvor mange kunder som ligger i listen min.
        System.out.println("Antall kunder i listen: " + customers.countNonNull());
        System.out.println(customers.toString());


        //Lager en ny kunde og henter peker fra tidligere kunde fra listen og setter den inn.
        Customer newCustomer = customers.getCustomer(1001);


        //Sletter kunde med kundenummer 1001 og 1003 fra listen, Sjekker om antallet i listen er oppdatert og skriver ut elementene via toString().
        customers.removeCustomer(10);//Finner ikke element, og gjør ingenting.
        customers.removeCustomer(1001); //Sletter kundenr 1001
        customers.removeCustomer(1003); //Sletter kundenr 1003

        System.out.println("Antall kunder i listen etter sletting: " + customers.countNonNull());
        System.out.println(customers.toString());

        //Legger kunden til igjen sjekker antall elementer i listen og skriver ut elementene via toString()
        customers.addCustomer(Customer_Rune);
        customers.addCustomer(Customer_William);

        System.out.println("Antall kunder i listen når kundene er lagt inn igjen: " + customers.countNonNull());
        System.out.println(customers.toString());


        //Lager ny liste med eksisterende kunder i listen.
        customers.addCustomer(Customer_Rune);
        Customer[] kundeliste = customers.getCustomers();
        //System.out.println(kundeliste[0].toString());



    }
}
