package session_nine_abstraction_interface.assignment_problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CollegeFeeCounter {
    // Interface representing the ability/choice to use the college bus
    public interface BusUser {
        double TRANSPORT_FEE = 12000.0;

        default double getTransportFee() {
            return TRANSPORT_FEE;
        }
    }

    public static abstract class Student {
        protected String name;

        public Student(String name) {
            this.name = name;
        }

        public abstract double getTuition();

        public double calculateTotalFee() {
            double total = getTuition();
            // Check if student is a BusUser without checking student type by name
            if (this instanceof BusUser) {
                total += ((BusUser) this).getTransportFee();
            }
            return total;
        }

        public String getName() {
            return name;
        }
    }

    public static class DayScholarStudent extends Student implements BusUser {
        public DayScholarStudent(String name) {
            super(name);
        }

        @Override
        public double getTuition() {
            return 40000.0;
        }
    }

    public static class HostellerStudent extends Student {
        public HostellerStudent(String name) {
            super(name);
        }

        @Override
        public double getTuition() {
            // tuition 40000 plus hostel fee 60000
            return 40000.0 + 60000.0;
        }
    }

    public static class ScholarshipStudent extends Student implements BusUser {
        public ScholarshipStudent(String name) {
            super(name);
        }

        @Override
        public double getTuition() {
            // half of normal tuition (20000)
            return 20000.0;
        }
    }

    public static void processStudents(List<Student> students) {
        double totalCollected = 0.0;
        for (Student student : students) {
            double fee = student.calculateTotalFee();
            totalCollected += fee;
            System.out.printf("%s: %.2f%n", student.getName(), fee);
        }
        System.out.printf("Total Collected: %.2f%n", totalCollected);
    }

    public static void main(String[] args) {
        String sampleInput = "3\nDAY_SCHOLAR Asha\nHOSTELLER Ravi\nSCHOLAR Neha";
        Scanner scanner = new Scanner(sampleInput);

        int n = Integer.parseInt(scanner.next());
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();

            switch (type) {
                case "DAY_SCHOLAR":
                    students.add(new DayScholarStudent(name));
                    break;
                case "HOSTELLER":
                    students.add(new HostellerStudent(name));
                    break;
                case "SCHOLAR":
                    students.add(new ScholarshipStudent(name));
                    break;
            }
        }
        scanner.close();

        processStudents(students);
    }
}
