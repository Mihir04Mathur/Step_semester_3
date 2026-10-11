package session_eight_polymorphism.assignment_problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CampusParkingChargeCalculator {
    public static abstract class ParkedVehicle {
        protected String typeName;
        protected int hours;

        public ParkedVehicle(String typeName, int hours) {
            this.typeName = typeName;
            this.hours = hours;
        }

        public abstract double calculateCharge();

        public String getTypeName() {
            return typeName;
        }
    }

    public static class BikeVehicle extends ParkedVehicle {
        public BikeVehicle(int hours) {
            super("BIKE", hours);
        }

        @Override
        public double calculateCharge() {
            return hours * 10.0;
        }
    }

    public static class CarVehicle extends ParkedVehicle {
        public CarVehicle(int hours) {
            super("CAR", hours);
        }

        @Override
        public double calculateCharge() {
            return 30.0 + (hours - 1) * 20.0;
        }
    }

    public static class TruckVehicle extends ParkedVehicle {
        public TruckVehicle(int hours) {
            super("TRUCK", hours);
        }

        @Override
        public double calculateCharge() {
            return Math.max(100.0, hours * 50.0);
        }
    }

    public static void processVehicles(List<ParkedVehicle> vehicles) {
        double grandTotal = 0.0;
        for (ParkedVehicle vehicle : vehicles) {
            double charge = vehicle.calculateCharge();
            grandTotal += charge;
            System.out.printf("%s: %.2f%n", vehicle.getTypeName(), charge);
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        String sampleInput = "4\nBIKE 3\nCAR 4\nTRUCK 1\nCAR 1";
        Scanner scanner = new Scanner(sampleInput);

        int n = Integer.parseInt(scanner.next());
        List<ParkedVehicle> vehicles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int hours = scanner.nextInt();
            switch (type) {
                case "BIKE":
                    vehicles.add(new BikeVehicle(hours));
                    break;
                case "CAR":
                    vehicles.add(new CarVehicle(hours));
                    break;
                case "TRUCK":
                    vehicles.add(new TruckVehicle(hours));
                    break;
            }
        }
        scanner.close();

        processVehicles(vehicles);
    }
}
