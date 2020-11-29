package java2.lesson1;

public class Competition {

    void tryCompetition() {
        Participant cat = new Cat("Кот", 10, 13);
        Participant human = new Human("Человек", 8, 5);
        Participant robot = new Robot("Робот", 10, 10);

        Participant[] participants = {cat, human, robot};


        Obstacle wall = new Wall(12);
        Obstacle treadmill = new Treadmill(18);

        Obstacle[] obstacles = {wall, treadmill};

        for (int i = 0; i < obstacles.length; i++) {

            for (Participant participant : participants) {
                if (participant.getSuccess()) {
                    obstacles[i].checkObstacle(participant);
                }


            }
        }
    }
        }

