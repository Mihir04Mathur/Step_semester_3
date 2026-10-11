package session_nine_abstraction_interface.assignment_problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieTicketCounter {
    // Abstract class ensures a plain ticket with no seat type can never be sold
    public static abstract class Ticket {
        protected int count;
        // The convenience fee is written in one place only
        protected static final double CONVENIENCE_FEE = 20.0;

        public Ticket(int count) {
            this.count = count;
        }

        public abstract double getBasePrice();

        public abstract String getSeatType();

        public double calculateAmount() {
            return (getBasePrice() + CONVENIENCE_FEE) * count;
        }
    }

    public static class RegularTicket extends Ticket {
        public RegularTicket(int count) {
            super(count);
        }

        @Override
        public double getBasePrice() {
            return 150.0;
        }

        @Override
        public String getSeatType() {
            return "REGULAR";
        }
    }

    public static class PremiumTicket extends Ticket {
        public PremiumTicket(int count) {
            super(count);
        }

        @Override
        public double getBasePrice() {
            return 250.0;
        }

        @Override
        public String getSeatType() {
            return "PREMIUM";
        }
    }

    public static class ReclinerTicket extends Ticket {
        public ReclinerTicket(int count) {
            super(count);
        }

        @Override
        public double getBasePrice() {
            return 400.0;
        }

        @Override
        public String getSeatType() {
            return "RECLINER";
        }
    }

    public static void processBookings(List<Ticket> bookings) {
        double total = 0.0;
        for (Ticket ticket : bookings) {
            double amount = ticket.calculateAmount();
            total += amount;
            System.out.printf("%s: %.2f%n", ticket.getSeatType(), amount);
        }
        System.out.printf("Total: %.2f%n", total);
    }

    public static void main(String[] args) {
        String sampleInput = "3\nREGULAR 3\nPREMIUM 2\nRECLINER 1";
        Scanner scanner = new Scanner(sampleInput);

        int n = Integer.parseInt(scanner.next());
        List<Ticket> bookings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String seat = scanner.next();
            int count = scanner.nextInt();
            switch (seat) {
                case "REGULAR":
                    bookings.add(new RegularTicket(count));
                    break;
                case "PREMIUM":
                    bookings.add(new PremiumTicket(count));
                    break;
                case "RECLINER":
                    bookings.add(new ReclinerTicket(count));
                    break;
            }
        }
        scanner.close();

        processBookings(bookings);
    }
}
