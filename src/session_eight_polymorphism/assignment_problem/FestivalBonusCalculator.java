package session_eight_polymorphism.assignment_problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FestivalBonusCalculator {
    public static abstract class CompanyEmployee {
        protected String name;
        protected double monthlySalary;

        public CompanyEmployee(String name, double monthlySalary) {
            this.name = name;
            this.monthlySalary = monthlySalary;
        }

        public abstract double calculateBonus();

        public String getName() {
            return name;
        }
    }

    public static class FullTimeEmployee extends CompanyEmployee {
        public FullTimeEmployee(String name, double monthlySalary) {
            super(name, monthlySalary);
        }

        @Override
        public double calculateBonus() {
            return monthlySalary * 0.10;
        }
    }

    public static class PartTimeEmployee extends CompanyEmployee {
        public PartTimeEmployee(String name, double monthlySalary) {
            super(name, monthlySalary);
        }

        @Override
        public double calculateBonus() {
            return monthlySalary * 0.05;
        }
    }

    public static class InternEmployee extends CompanyEmployee {
        public InternEmployee(String name, double monthlySalary) {
            super(name, monthlySalary);
        }

        @Override
        public double calculateBonus() {
            return 2000.00;
        }
    }

    public static void processBonuses(List<CompanyEmployee> employees) {
        double grandTotal = 0.0;
        for (CompanyEmployee emp : employees) {
            double bonus = emp.calculateBonus();
            grandTotal += bonus;
            System.out.printf("%s: %.2f%n", emp.getName(), bonus);
        }
        System.out.printf("Total Bonus: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        String sampleInput = "3\nFULLTIME Asha 50000\nPARTTIME Ravi 30000\nINTERN Neha 15000";
        Scanner scanner = new Scanner(sampleInput);

        int n = Integer.parseInt(scanner.next());
        List<CompanyEmployee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            double salary = scanner.nextDouble();
            switch (type) {
                case "FULLTIME":
                    employees.add(new FullTimeEmployee(name, salary));
                    break;
                case "PARTTIME":
                    employees.add(new PartTimeEmployee(name, salary));
                    break;
                case "INTERN":
                    employees.add(new InternEmployee(name, salary));
                    break;
            }
        }
        scanner.close();

        processBonuses(employees);
    }
}
