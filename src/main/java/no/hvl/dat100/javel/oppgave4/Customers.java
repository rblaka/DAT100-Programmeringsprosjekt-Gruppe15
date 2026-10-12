package no.hvl.dat100.javel.oppgave4;

import no.hvl.dat100.javel.oppgave3.Customer;

public class Customers {

    private Customer[] customers;

    // a) Complete constructor
    public Customers(int size) {
        customers = new Customer[size];

    }

    // b) count number of non-null references
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
    public Customer getCustomer(int customer_id) {

        boolean funnet = false;
        Customer c = null;

        int i = 0;
        while(!funnet){
            if( i == customers.length){
                break;
            }
            else if(customers[i].getCustomer_id() == customer_id){
                funnet = true;
                c = customers[i];
            }
            else{
                i++;
            }
        }
        return c;
    }

    // d) add a customer to the reference table
    public boolean addCustomer(Customer c) {

        boolean inserted = false;

        if(countNonNull() < customers.length){
            customers[countNonNull()] = c;
            inserted = true;
        }

        return inserted;
    }

    // e) remove customer with given id from reference table
    public Customer removeCustomer(int customer_id) {

        boolean deleted = false;
        Customer c = null;

        // TODO

        return c;
    }

    // f) return reference table with all customers
    public Customer[] getCustomers() {

        Customer[] customers = null;

        // TODO

        return customers;
    }
}