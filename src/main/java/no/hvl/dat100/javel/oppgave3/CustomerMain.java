package no.hvl.dat100.javel.oppgave3;

import no.hvl.dat100.javel.oppgave4.Customers;

public class CustomerMain {

    public static void main(String[] args) {

        System.out.println("==============");
        System.out.println("OPPGAVE 3");
        System.out.println("==============");
        System.out.println();

        Customer kunde = new Customer("Rune", "rune@gmail.com", 1001, PowerAgreementType.NORGESPRICE);
        //Test av metoder:

        //Test av toString() metoden
        System.out.println(kunde.toString());

        System.out.println();
        System.out.println("Endringer: ");

        //Test av setName() og getName() metodene. Forventet utskrift: Kata
        kunde.setName("Kata");
        System.out.println(kunde.getName());

        //Test av setEmail() og getEmail() metodene. Forventet utskrift: kata@gmail.com
        kunde.setEmail("Kata@gmail.com");
        System.out.println(kunde.getEmail());

        //Test av setCustomer_id() og getCustomer_id() metodene. Forventet utskrift: 1002
        kunde.setCustomer_id(1002);
        System.out.println(kunde.getCustomer_id());

        //Test av setAgreement() og getAgreement() metodene. Forventet utskrift: "SPOTPRICE"
        kunde.setAgreement(PowerAgreementType.SPOTPRICE);
        System.out.println(kunde.getAgreement());

    }
}
