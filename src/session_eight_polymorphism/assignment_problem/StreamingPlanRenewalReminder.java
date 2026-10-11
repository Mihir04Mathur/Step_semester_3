package session_eight_polymorphism.assignment_problem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StreamingPlanRenewalReminder {
    public static abstract class StreamingSubscriber {
        protected String name;
        protected LocalDate startDate;

        public StreamingSubscriber(String name, LocalDate startDate) {
            this.name = name;
            this.startDate = startDate;
        }

        public abstract LocalDate calculateRenewalDate();

        public String getName() {
            return name;
        }
    }

    public static class BasicSubscriber extends StreamingSubscriber {
        public BasicSubscriber(String name, LocalDate startDate) {
            super(name, startDate);
        }

        @Override
        public LocalDate calculateRenewalDate() {
            return startDate.plusDays(30);
        }
    }

    public static class StandardSubscriber extends StreamingSubscriber {
        public StandardSubscriber(String name, LocalDate startDate) {
            super(name, startDate);
        }

        @Override
        public LocalDate calculateRenewalDate() {
            return startDate.plusDays(90);
        }
    }

    public static class PremiumSubscriber extends StreamingSubscriber {
        public PremiumSubscriber(String name, LocalDate startDate) {
            super(name, startDate);
        }

        @Override
        public LocalDate calculateRenewalDate() {
            return startDate.plusDays(365);
        }
    }

    public static void processSubscribers(List<StreamingSubscriber> subscribers) {
        for (StreamingSubscriber sub : subscribers) {
            System.out.println(sub.getName() + ": " + sub.calculateRenewalDate());
        }
    }

    public static void main(String[] args) {
        String sampleInput = "4\nBASIC Asha 2024-01-15\nSTANDARD Ravi 2024-02-01\nPREMIUM Neha 2024-03-10\nBASIC Kiran 2024-12-20";
        Scanner scanner = new Scanner(sampleInput);

        int n = Integer.parseInt(scanner.next());
        List<StreamingSubscriber> subscribers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String plan = scanner.next();
            String name = scanner.next();
            String dateStr = scanner.next();
            LocalDate startDate = LocalDate.parse(dateStr);

            switch (plan) {
                case "BASIC":
                    subscribers.add(new BasicSubscriber(name, startDate));
                    break;
                case "STANDARD":
                    subscribers.add(new StandardSubscriber(name, startDate));
                    break;
                case "PREMIUM":
                    subscribers.add(new PremiumSubscriber(name, startDate));
                    break;
            }
        }
        scanner.close();

        processSubscribers(subscribers);
    }
}
