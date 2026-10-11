package session_nine_abstraction_interface.assignment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CityCabFareMeter {
    // Interface representing cabs that can offer night service
    public interface NightServiceable {
        default double applyNightSurcharge(double baseFare) {
            return baseFare * 1.20;
        }
    }

    public static abstract class CabTrip {
        protected String cabType;
        protected double ratePerKm;
        protected double distanceKm;
        protected String timeOfDay;

        public CabTrip(String cabType, double ratePerKm, double distanceKm, String timeOfDay) {
            this.cabType = cabType;
            this.ratePerKm = ratePerKm;
            this.distanceKm = distanceKm;
            this.timeOfDay = timeOfDay;
        }

        public double calculateBaseFare() {
            // Fare = distance * rate, but never less than 100
            return Math.max(100.0, distanceKm * ratePerKm);
        }

        public abstract Double calculateFinalFare();

        public String getCabType() {
            return cabType;
        }
    }

    public static class MiniCabTrip extends CabTrip {
        public MiniCabTrip(double distanceKm, String timeOfDay) {
            super("MINI", 10.0, distanceKm, timeOfDay);
        }

        @Override
        public Double calculateFinalFare() {
            if ("NIGHT".equalsIgnoreCase(timeOfDay)) {
                return null; // Night service not available for mini
            }
            return calculateBaseFare();
        }
    }

    public static class SedanCabTrip extends CabTrip implements NightServiceable {
        public SedanCabTrip(double distanceKm, String timeOfDay) {
            super("SEDAN", 14.0, distanceKm, timeOfDay);
        }

        @Override
        public Double calculateFinalFare() {
            double fare = calculateBaseFare();
            if ("NIGHT".equalsIgnoreCase(timeOfDay)) {
                fare = applyNightSurcharge(fare);
            }
            return fare;
        }
    }

    public static class SUVCabTrip extends CabTrip implements NightServiceable {
        public SUVCabTrip(double distanceKm, String timeOfDay) {
            super("SUV", 18.0, distanceKm, timeOfDay);
        }

        @Override
        public Double calculateFinalFare() {
            double fare = calculateBaseFare();
            if ("NIGHT".equalsIgnoreCase(timeOfDay)) {
                fare = applyNightSurcharge(fare);
            }
            return fare;
        }
    }

    public static void processTrips(List<CabTrip> trips) {
        double totalCompleted = 0.0;
        for (CabTrip trip : trips) {
            Double fare = trip.calculateFinalFare();
            if (fare == null) {
                System.out.printf("%s: night service not available%n", trip.getCabType());
            } else {
                totalCompleted += fare;
                System.out.printf("%s: %.2f%n", trip.getCabType(), fare);
            }
        }
        System.out.printf("Total: %.2f%n", totalCompleted);
    }

    public static void main(String[] args) {
        String sampleInput = "4\nMINI 8 DAY\nSEDAN 10 NIGHT\nSUV 20 DAY\nMINI 5 NIGHT";
        Scanner scanner = new Scanner(sampleInput);

        int n = Integer.parseInt(scanner.next());
        List<CabTrip> trips = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double km = scanner.nextDouble();
            String time = scanner.next();

            switch (type) {
                case "MINI":
                    trips.add(new MiniCabTrip(km, time));
                    break;
                case "SEDAN":
                    trips.add(new SedanCabTrip(km, time));
                    break;
                case "SUV":
                    trips.add(new SUVCabTrip(km, time));
                    break;
            }
        }
        scanner.close();

        processTrips(trips);
    }
}
