package no.hvl.dat100.javel.oppgave3;

//En klasse for kunne lage kunde-objekter. Dette objektet skal knytte sammen forbruk, strømavtale(Mtp prisberegning) og fakturering.

public class Customer {

    //Variablene er satt til privat, og er tilgjengelig via get- og set-metodene.
    private String name  = "";
    private String email = "";
    private int customer_id = 0;
    private PowerAgreementType agreement;

    //Konstruktør
    public Customer(String name, String email, int customer_id, PowerAgreementType agreement) {

        this.name = name;
        this.email = email;
        this.customer_id = customer_id;
        this.agreement = agreement;
    }
    //Getters and setters for å kunne hente og sette verdier til variablene i objektet.
    public void setName(String newName){
        name = newName;
    }
    public void setEmail(String newEmail){
        email = newEmail;
    }
    public void setCustomer_id(int newCustomer_id){
        customer_id = newCustomer_id;
    }
    public void setAgreement(PowerAgreementType newAgreement){
        agreement = newAgreement;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public int getCustomer_id(){
        return customer_id;
    }
    public PowerAgreementType getAgreement(){
        return agreement;
    }

    //overskrive standard toString() med denne metoden.
    public String toString(){
        String output =
        "Customer number " + customer_id + "\r\n" +
        "Name " + name + "\r\n" +
        "Email " + email + "\r\n" +
        "Agreement " + agreement;

        return output;
    }

}
