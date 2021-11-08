package com.mpli.messagerie;

import java.util.ArrayList;

public class Message {
    String text;
    Contact person;
    static ArrayList<Message> Message_list = new ArrayList<>();

    public Message(String text, Contact person) {
        this.text = text;
        this.person = person;
    }

    static boolean show_messages() {
        int i = 1;
        for (Message s: Message_list) {
            System.out.println(i + ". " + s.text + " -> " + s.person.name);
            System.out.println("-------------------------");
            i += 1;
        }
        return i == 1;
    }
    public void send_message(String txt, String name) {
        person.name = name;
        Message n_message = new Message(txt, person);
        Message_list.add(n_message);
        System.out.println("Message successfully sent to " + person.name);
    }
}
