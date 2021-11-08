package com.mpli.messagerie;


import java.util.ArrayList;

public class Contact {
    String name;
    String number;
    static ArrayList<Contact> contacts = new ArrayList<>();

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public Contact(String name) {
        this.name = name;
    }


    public void add_contact(String name, String number) {
        Contact c_contacts = new Contact(name, number);
        contacts.add(c_contacts);
        System.out.println("You have added \"" + c_contacts.name + "\" in your contact\n" +
                "with the number: " + c_contacts.number + "\n");
    }
    static public boolean show_contact() {
        int i = 1;
        for (Contact s: contacts) {
            System.out.println(i + ". name: " + s.name  + " number: " + s.number );
            i += 1;
        }
        return i == 1;
    }
    static public boolean searching_contact(String data) {
       for (Contact s: contacts) {
           if (s.name.equals(data) || s.number.equals(data)) {
               System.out.println("Research completed, here is your contact:\n" +
                       "name: " + s.name + " number: " + s.number);
               return true;
           } else {
               System.out.println("Searching...");
           }
       }
       return false;
    }
    static public boolean delete_contact(String data) {
        int i = 0;
        for (Contact s: contacts) {
            if (s.name.equals(data)) {
                System.out.println("You have delete the contact:\n" +
                        "name: " + s.name + " number: " + s.number);
                contacts.remove(i);
                return false;
            }
            i = i + 1;
        }
        return true;
    }

}
