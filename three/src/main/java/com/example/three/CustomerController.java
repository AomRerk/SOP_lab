package com.example.three;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CustomerController {
    private List<Customer> customers;

    public CustomerController(){
        this.customers = new ArrayList();
        this.customers.add(new Customer("1010", "John", "Male", 25));
        this.customers.add(new Customer("1018", "Peter", "Male", 25));
        this.customers.add(new Customer("1019", "Sara", "Female", 25));
        this.customers.add(new Customer("1110", "Rose", "Female", 25));
        this.customers.add(new Customer("1001", "Emma", "Female", 25));
    }
    @RequestMapping(value="/customers")
    public List<Customer> getCustomers(){
        return this.customers;
    }
    @RequestMapping(value="/customerbyid/{id}")
    public Customer getCustomerByID(@PathVariable String id){
        for (int i = 0; i <= this.customers.size(); i++) {
            if (this.customers.get(i).getID().equals(id)){
                return this.customers.get(i);
            }
        }
        return null;
    }
    @RequestMapping(value="/customerbyname/{n}")
    public Customer getCustomerByName(@PathVariable String n){
        for (int i = 0; i <= this.customers.size(); i++) {
            if (this.customers.get(i).getName().equals(n)){
                return this.customers.get(i);
            }
        }
        return null;
    }
    @RequestMapping(value="/customerDelByid/{id}", method = RequestMethod.DELETE)
    public boolean delCustomerByID(@PathVariable String id){
        for (int i = 0; i <= this.customers.size(); i++) {
            if (this.customers.get(i).getID().equals(id)){
                this.customers.remove(i);
                return true;
            }
        }
        return false;
    }
    @RequestMapping(value="/customerDelByname/{n}", method = RequestMethod.DELETE)
    public boolean delCustomerByName(@PathVariable String n){
        for (int i = 0; i <= this.customers.size(); i++) {
            if (this.customers.get(i).getName().equals(n)){
                this.customers.remove(i);
                return true;
            }
        }
        return false;
    }
    @RequestMapping(value="/addCustomer")
    public boolean addCustomer(@RequestParam String id, @RequestParam String name, @RequestParam String sex, @RequestParam int age){
        this.customers.add(new Customer(id, name, sex, age));
        return true;
    }

    @RequestMapping(value="/addCustomer2", method = RequestMethod.POST)
    public boolean addCustomer2(@RequestParam String id, @RequestParam String name, @RequestParam String sex, @RequestParam int age){
        this.customers.add(new Customer(id, name, sex, age));
        return true;
    }

//    ข้อ8 errorเพราะmethodผิด
}
