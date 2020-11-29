package java2.lesson1;

public class Human implements Participant{
    private String name;
    private int maxLength;
    private int maxHeight;
    private boolean success = true;


    public Human(String name, int maxLength, int maxHeight) {
        this.name = name;
        this.maxLength = maxLength;
        this.maxHeight = maxHeight;
    }

    public int run() {
        return maxLength;
    }
    public int jump() {
        return maxHeight;
    }
    public boolean getSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
}
