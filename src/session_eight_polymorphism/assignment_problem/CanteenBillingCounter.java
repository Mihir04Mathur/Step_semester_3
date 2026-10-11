package session_eight_polymorphism.assignment_problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CanteenBillingCounter {
    public static abstract class CustomerBill {
        protected String typeName;
        protected double billAmount;

        public CustomerBill(String typeName, double billAmount) {
            this.typeName = typeName;
            this.billAmount = billAmount;
        }

        public abstract double calculateFinalAmount();

        public String getTypeName() {
            return typeName;
        }
    }

    public static class StudentBill extends CustomerBill {
        public StudentBill(double billAmount) {
            super("STUDENT", billAmount);
        }

        @Override
        public double calculateFinalAmount() {
            return billAmount * 0.90; // 10% discount
        }
    }

    public static class StaffBill extends CustomerBill {
        public StaffBill(double billAmount) {
            super("STAFF", billAmount);
        }

        @Override
        public double calculateFinalAmount() {
            return billAmount * 0.95; // 5% discount
        }
    }

    public static class GuestBill extends CustomerBill {
        public GuestBill(double billAmount) {
            super("GUEST", billAmount);
        }

        @Override
        public double calculateFinalAmount() {
            return billAmount + 10.0; // 10 service charge
        }
    }

    public static void processBills(List<CustomerBill> bills) {
        double grandTotal = 0.0;
        for (CustomerBill bill : bills) {
            double finalAmount = bill.calculateFinalAmount();
            grandTotal += finalAmount;
            System.out.printf("%s: %.2f%n", bill.getTypeName(), finalAmount);
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        String sampleInput = "3\nSTUDENT 200\nSTAFF 300\nGUEST 150";
        Scanner scanner = new Scanner(sampleInput);

        int n = Integer.parseInt(scanner.next());
        List<CustomerBill> bills = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();
            switch (type) {
                case "STUDENT":
                    bills.add(new StudentBill(amount));
                    break;
                case "STAFF":
                    bills.add(new StaffBill(amount));
                    break;
                case "GUEST":
                    bills.add(new GuestBill(amount));
                    break;
            }
        }
        scanner.close();

        processBills(bills);
    }
}
