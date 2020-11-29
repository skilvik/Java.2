package java2.lesson1;

public class Wall implements Obstacle{

    public int height;

    public Wall(int height) {
        this.height = height;
    }
    public boolean checkObstacle(Participant participant) {
        if (participant.jump() >= height) {
            System.out.println(participant + "перепрыгнул");
            return true;
        }
        else {
            System.out.println(participant + "не перепрыгнул");
            return false;
        }
    }
}
