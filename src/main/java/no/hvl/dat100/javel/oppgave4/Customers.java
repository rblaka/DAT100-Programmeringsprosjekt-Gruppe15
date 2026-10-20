package no.hvl.dat100.javel.oppgave4;

import no.hvl.dat100.javel.oppgave3.Customer;

//Klasse som brukes for å samle kundene slik at kundeoversikt og total fakturering blir enklere.
public class Customers {

    //Listen over kunder. bruk get- og set-metodene til å endre denne.
    private Customer[] customers;

    // a) Complete constructor
    //Her initieres kundelisten med en gitt størrelse du måtte velge.
    public Customers(int size) {
        customers = new Customer[size];
    }

    // b) count number of non-null references
    //Metode som returnerer antall faktiske kunder i listen. (Man kan ha en stor liste som er tom for kunder, og da vil denne returnere 0)
    public int countNonNull() {
        int count = 0;
        for (int i = 0; i < customers.length; i++) {
            if(customers[i] != null) {
                count++;
            }
        }
        return count;
    }

    // c) return reference to customer with given id (if exists)
    /*Noen(Meg) følger med i DAT100-timen og har innsett at det var lurt å endre algoritmen til å kun
    itterere igjennom delen av listen som kun inneholder kunder ved bruk av countNonNull-metoden. Takk, Sven-Olai*/
    public Customer getCustomer(int customer_id) {

        boolean funnet = false;
        Customer c = null;

        int i = 0;
        int antall = countNonNull();
        while(!funnet && i < antall && antall > 0){
            if(customers[i].getCustomer_id() == customer_id){
                funnet = true;
                c = customers[i];
            }
            i++;
        }
        return c;
    }

    // d) add a customer to the reference table
    /*Noen(Meg) følger med i DAT100-timen og har innsett at det var lurt å endre algoritmen til å kun
    itterere igjennom delen av listen som kun inneholder kunder ved bruk av countNonNull-metoden. Takk, Sven-Olai*/
    //Sjekker at listen ikke er full, og legger inn nytt element etter forrige kund i listen.

    public boolean addCustomer(Customer c) {

        boolean inserted = false;
        int antall = countNonNull();
        if(antall < customers.length && antall >= 0){
            customers[antall] = c;
            inserted = true;
        }
        return inserted;
    }

    // e) remove customer with given id from reference table
    /*Noen(Meg) følger med i DAT100-timen og har innsett at det var lurt å endre algoritmen til å kun
    itterere igjennom den delen av listen som kun inneholder kunder, ved bruk av countNonNull-metoden.
    Takk til Sven-Olai for at vi fikk fremvist denne algoritmen visuelt på tavlen*/
    public Customer removeCustomer(int customer_id) {

        boolean deleted = false;
        Customer c = null;

        int i = 0;
        int antall = countNonNull();
        while(!deleted && i < antall && antall > 0){
            if(customers[i].getCustomer_id() == customer_id){
                c = customers[i];
                customers[i] = customers[antall-1];
                customers[antall-1] = null;
                deleted = true;
            }
            i++;
        }
        return c;
    }

    // f) return reference table with all customers
    /*Noen(Meg) følger med i DAT100-timen og har innsett at det var lurt å endre algoritmen til å kun
    itterere igjennom delen av listen som kun inneholder kunder ved bruk av countNonNull-metoden. Takk, Sven-Olai
    Det gjorde det enklere å skrive metoden*/
    public Customer[] getCustomers() {

        Customer[] customers = null;
        int antall = countNonNull();
        customers = new Customer[antall];
        int i = 0;

        while (i < antall && antall > 0) {
            customers[i] = this.customers[i];
            i++;
        }
        return customers;
    }

    //La til en ekstra toString()-metode for å verifisere om listeinnholdet er riktig når man bruker metodene som sletter og legger inn elementer i listen.
    public String toString(){
        String output = "";
        int antall = countNonNull();
        for(int i = 0; i < antall; i++){
            output += customers[i].toString() + "\r\n" + "\r\n";
        }
        return output;
    }
}