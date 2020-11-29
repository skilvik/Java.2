package java2.lesson1;

public class Treadmill implements Obstacle{

    private int length;

    public Treadmill(int length) {
        this.length = length;
    }

    public boolean checkObstacle(Participant participant) {
        if (participant.run() >= length) {
            System.out.println(participant + "пробежал");
            return true;
        }
        else {
            System.out.println(participant + "не пробежал");
            return false;
        }
    }
}
