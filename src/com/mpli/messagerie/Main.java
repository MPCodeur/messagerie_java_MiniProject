package com.mpli.messagerie;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Main {
    public static void Main_aff(){
        System.out.println("\t1. Manage contacts");
        System.out.println("\t2. Messages");
        System.out.println("\t3. Quit");
    }
    public static void Contact_aff(){
        System.out.println("\t1. Show all contact");
        System.out.println("\t2. Add a new contact");
        System.out.println("\t3. Search for a contact");
        System.out.println("\t4. Delete a contact");
        System.out.println("\t5. Go back to the previous menu");
    }
    public static void Message_aff() {
        System.out.println("\t 1. See the list of all Messages");
        System.out.println("\t 2. Send a new Message");
        System.out.println("\t 3. Go back to the previous menu");
    }

    public static void Contact_function(@NotNull String second_choice) {
        Scanner scan = new Scanner(System.in);
        while (!second_choice.equals("5")) {
            switch (second_choice) {
                case "1":
                    if (!Contact.show_contact())
                        break;
                    else
                        System.out.println("There is no contact here");
                    break;
                case "2":
                    System.out.println("Please enter the name and the number");
                    String name = scan.next();
                    String number = scan.next();
                    Contact newOne = new Contact(name, number);
                    newOne.add_contact(name, number);
                    break;
                case "3":
                    System.out.println("Please enter the name or number of the contact");
                    String data = scan.next();
                    if (Contact.searching_contact(data))
                        break;
                    else
                        System.out.println("The contact does not exist");
                    break;
                case "4":
                    System.out.println("Please enter the name");
                    data = scan.next();
                    if (!Contact.delete_contact(data))
                        break;
                    else
                        System.out.println("The name given does not exist as a contact");
                    break;

                default:
                    System.out.println("Please enter a number");
                    break;
            }
            Contact_aff();
            second_choice = scan.next();
        }
    }
    public static void Message_function(@NotNull String second_choice) {
        Scanner scan = new Scanner(System.in);
        while (!second_choice.equals("3")) {
            switch (second_choice) {
                case "1":
                    if (!Message.show_messages())
                        break;
                    else
                        System.out.println("There is no message here");
                    break;
                case "2":
                    System.out.println("Who are you going to send a message");
                    String recipient = scan.next();
                    if (Contact.searching_contact(recipient)) {
                        Contact newC = new Contact(recipient);
                        System.out.println("What do you want to say ?");
                        scan.nextLine();
                        String message = scan.nextLine();
                        Message newM = new Message(message, newC);
                        newM.send_message(message, recipient);
                    }
                    else {
                        System.out.println("There no contact with that name");
                        break;
                    }
                    break;
                default:
                    System.out.println("Please enter a number");
                    break;
            }
            Message_aff();
            second_choice = scan.next();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Message Application");
        Main_aff();
        String Main_choice = scan.next();

        while (!Main_choice.equals("3")) {
            switch (Main_choice) {
                case "1":
                    Contact_aff();
                    String second_choice = scan.next();
                    Contact_function(second_choice);
                    break;
                case "2":
                    Message_aff();
                    second_choice = scan.next();
                    Message_function(second_choice);
                    break;
                default:
                    System.out.println("Please enter a number");
                    break;
            }
            Main_aff();
            Main_choice = scan.next();
        }
    }
}
