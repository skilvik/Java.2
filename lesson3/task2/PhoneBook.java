package java2.lesson3.task2;

import java.util.*;

public class PhoneBook {



    private HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

    public void add(String surname, String phone) {
        ArrayList<String> phones = phoneBook.get(surname);
        if (phones.isEmpty()) phones = new ArrayList<>();
        phones.add(phone);
        phoneBook.put(surname, phones);
    }

    public ArrayList<String> get(String surname) {
        return phoneBook.get(surname);
    }
}




//    private final Map<String, Set<String>> phoneBook;
//
//    public PhoneBook() {
//        phoneBook = new HashMap<>();
//    }
//
//    public void add(String surname, String phone) {
//
//    }

