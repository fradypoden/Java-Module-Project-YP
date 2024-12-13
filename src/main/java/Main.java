import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<vehicle> vehicle = new ArrayList<>();

        for (int i = 1; i < 4; i++) {
            System.out.println("Введите название машины №" + i);
            String carName = scanner.nextLine();
            System.out.println("Введите скорость для машины №" + i);

            boolean check = true;
            while (check) {
                if (scanner.hasNextInt()) {
                    int speed = scanner.nextInt();
                    if (speed > 0 & speed <= 250) {
                        scanner.nextLine();
                        vehicle.add(new vehicle(carName, speed));
                        race.Calculation(carName, speed);
                        check = false;
                    } else {
                        System.out.println("Неправильная скорость");
                        scanner.nextLine();
                        System.out.println("Введите скорость для машины №" + i);
                    }

                } else {
                    System.out.println("Неправильная скорость");
                    scanner.nextLine();
                    System.out.println("Введите скорость для машины №" + i);
                }
            }
        }
        System.out.println("Самая быстрая машина: " + race.nameOfNewLeader);
    }
}

class vehicle {
    String carName;
    int speed;

    public vehicle(String carName, int speed) {
        this.carName = carName;
        this.speed = speed;
    }
}

class race {
    static String nameOfNewLeader = "";
    static int distance = 0;

    public static void Calculation(String carName, int speed) {
        int distanceCalculation = speed * 24;

        if (distanceCalculation > distance) {
            nameOfNewLeader = carName;
            distance = distanceCalculation;
        }
    }
}
