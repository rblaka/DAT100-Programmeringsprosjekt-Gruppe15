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

        customers.addCustomer(Customer_Rune);
        customers.addCustomer(Customer_Kata);


        //Sjekker hvor mange kunder som ligger i listen min.
        System.out.println(customers.countNonNull());

        //Lager en ny kunde og henter peker fra tidligere kunde fra listen og setter den inn.
        Customer newCustomer = customers.getCustomer(1001);
        System.out.println(newCustomer.toString());

    }
}
