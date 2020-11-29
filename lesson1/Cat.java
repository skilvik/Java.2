package java2.lesson1;

public class Cat implements Participant{
    private String name;
    private int maxLength;
    private int maxHeight;
    private boolean success = true;


    public Cat(String name, int maxLength, int maxHeight) {
        this.name = name;
        this.maxLength = maxLength;
        this.maxHeight = maxHeight;
    }

    public int run() {
        System.out.printf("Кот %s бежит дистанцию %d%n", name, maxLength);
        return maxLength;
    }
    public int jump() {
        System.out.printf("Кот %s прыгает %d%n", name, maxHeight);
        return maxHeight;
    }
    public boolean getSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
}
