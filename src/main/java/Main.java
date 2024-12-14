import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Vehicle> vehicleList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            System.out.println("Введите название машины №" + (i + 1));
            String carName = scanner.next();
            carName = carName + scanner.nextLine();
            System.out.println("Введите скорость для машины №" + (i + 1));

            while (true) {
                if (scanner.hasNextInt()) {
                    int speed = scanner.nextInt();
                    if (speed > 0 & speed <= 250) {
                        scanner.nextLine();
                        vehicleList.add(new Vehicle(carName, speed));
                        Race.calculation(vehicleList.get(i));
                        break;
                    } else {
                        System.out.println("Неправильная скорость");
                        scanner.nextLine();
                        System.out.println("Введите скорость для машины №" + (i + 1));
                    }
                } else {
                    System.out.println("Неправильная скорость");
                    scanner.next();
                    scanner.nextLine();
                    System.out.println("Введите скорость для машины №" + (i + 1));
                }
            }
        }
        System.out.println("Самая быстрая машина: " + Race.nameOfNewLeader);
    }
}

class Vehicle {
    String carName;
    int speed;

    public Vehicle(String carName, int speed) {
        this.carName = carName;
        this.speed = speed;
    }
}

class Race {
    static String nameOfNewLeader = "";
    static int distance = 0;

    public static void calculation(Vehicle vehicle) {
        int distanceCalculation = vehicle.speed * 24;

        if (distanceCalculation > distance) {
            nameOfNewLeader = vehicle.carName;
            distance = distanceCalculation;
        }
    }
}
