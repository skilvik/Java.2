package java2.lesson2;

public class MyArrayDataException extends RuntimeException{
    public MyArrayDataException(int i, int j) {
        super(String.format("[%d][%d]", i, j));
    }
}
