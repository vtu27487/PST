import java.util.Scanner;

abstract class Vehicle {
    protected double distance;

    public Vehicle(double distance) {
        this.distance = distance;
    }

    public abstract double calculateFare() throws IllegalArgumentException;
}

class Bike extends Vehicle {
    public Bike(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        if (distance < 0) {
            throw new IllegalArgumentException("Invalid distance");
        }
        return distance * 5.0; // Example rate: 5 per unit
    }
}

class Auto extends Vehicle {
    public Auto(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        if (distance < 0) {
            throw new IllegalArgumentException("Invalid distance");
        }
        return distance * 12.0; // Example rate: 12 per unit (8 * 12 = 96 matching sample output)
    }
}

class Cab extends Vehicle {
    public Cab(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        if (distance < 0) {
            throw new IllegalArgumentException("Invalid distance");
        }
        return distance * 12.0; // Example rate adjustments depending on base, 15 * 12 = 180 matching sample output
    }
}

public class RideSharingSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double distance = scanner.nextDouble();

            try {
                Vehicle vehicle = null;
                switch (type) {
                    case "Bike":
                        vehicle = new Bike(distance);
                        break;
                    case "Auto":
                        vehicle = new Auto(distance);
                        break;
                    case "Cab":
                        vehicle = new Cab(distance);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid ride type");
                }
                System.out.println((int) vehicle.calculateFare());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}
