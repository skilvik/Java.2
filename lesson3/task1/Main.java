package java2.lesson3.task1;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<String> unique = new HashSet<String>(Arrays.asList(WORDS));

        System.out.print("список уникальных слов: ");
        System.out.println(unique.toString());
        for (String key : unique) {
            System.out.println("слово '" + key + "' встречается " + Collections.frequency(Arrays.asList(WORDS), key) + " раз.");
        }

    }

    private static final String[] WORDS= {
            "do", "re", "do",
            "do", "re", "mi", "re", "do",
            "do", "re", "mi", "fa", "mi", "re", "do",
    };
}
