package session_nine_abstraction_interface.assignment_problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParcelShippingDesk {
    public interface Insurable {
        double calculateInsurance();
    }

    public static abstract class Parcel {
        protected double weightKg;
        protected double declaredValue;
        protected String typeName;

        public Parcel(String typeName, double weightKg, double declaredValue) {
            this.typeName = typeName;
            this.weightKg = weightKg;
            this.declaredValue = declaredValue;
        }

        public abstract double calculateShippingCharge();

        public double getInsuranceAmount() {
            if (this instanceof Insurable) {
                return ((Insurable) this).calculateInsurance();
            }
            return 0.00;
        }

        public double calculateTotal() {
            return calculateShippingCharge() + getInsuranceAmount();
        }

        public String getTypeName() {
            return typeName;
        }
    }

    public static class StandardParcel extends Parcel {
        public StandardParcel(double weightKg, double declaredValue) {
            super("STANDARD", weightKg, declaredValue);
        }

        @Override
        public double calculateShippingCharge() {
            return 40.0 + 10.0 * weightKg;
        }
    }

    public static class ExpressParcel extends Parcel implements Insurable {
        public ExpressParcel(double weightKg, double declaredValue) {
            super("EXPRESS", weightKg, declaredValue);
        }

        @Override
        public double calculateShippingCharge() {
            return 80.0 + 15.0 * weightKg;
        }

        @Override
        public double calculateInsurance() {
            return 0.02 * declaredValue;
        }
    }

    public static class FragileParcel extends Parcel implements Insurable {
        public FragileParcel(double weightKg, double declaredValue) {
            super("FRAGILE", weightKg, declaredValue);
        }

        @Override
        public double calculateShippingCharge() {
            // standard charge plus a handling fee of 50
            return (40.0 + 10.0 * weightKg) + 50.0;
        }

        @Override
        public double calculateInsurance() {
            return 0.02 * declaredValue;
        }
    }

    public static void processParcels(List<Parcel> parcels) {
        double grandTotal = 0.0;
        for (Parcel parcel : parcels) {
            double charge = parcel.calculateShippingCharge();
            double insurance = parcel.getInsuranceAmount();
            double total = parcel.calculateTotal();
            grandTotal += total;

            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    parcel.getTypeName(), charge, insurance, total);
        }
        System.out.printf("Grand Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        String sampleInput = "3\nSTANDARD 3 500\nEXPRESS 2 1000\nFRAGILE 4 2000";
        Scanner scanner = new Scanner(sampleInput);

        int n = Integer.parseInt(scanner.next());
        List<Parcel> parcels = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double value = scanner.nextDouble();

            switch (type) {
                case "STANDARD":
                    parcels.add(new StandardParcel(weight, value));
                    break;
                case "EXPRESS":
                    parcels.add(new ExpressParcel(weight, value));
                    break;
                case "FRAGILE":
                    parcels.add(new FragileParcel(weight, value));
                    break;
            }
        }
        scanner.close();

        processParcels(parcels);
    }
}
