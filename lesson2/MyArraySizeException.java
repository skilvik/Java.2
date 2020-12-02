package java2.lesson2;

public class MyArraySizeException extends RuntimeException{
    public MyArraySizeException() {
        super("Некорректный размер массива.");
    }

}
