package java2.lesson3.task2;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("a", "111");
        phoneBook.add("a", "222");
        phoneBook.add("b", "333");
        phoneBook.add("b", "444");
        phoneBook.add("c", "555");
        phoneBook.add("d", "666");


        phoneBook.get("a");
        phoneBook.get("b");
        phoneBook.get("c");
    }
}
