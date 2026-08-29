package control_flow.assigment_problems;

public class GradeClassifier {
    public void classifyWithAttendance(int marks, int attendance) {
        if (attendance >= 75 && marks >= 40) {
            if (marks >= 90) {
                System.out.println("Grade: A");
            } else if (marks >= 75) {
                System.out.println("Grade: B");
            } else if (marks >= 60) {
                System.out.println("Grade: C");
            } else {
                System.out.println("Grade: D");
            }
        } else {
            System.out.println("Detained");
        }
    }

    public static void main(String[] args) {
        GradeClassifier classifier = new GradeClassifier();
        System.out.print("marks = 82, attendance = 80: ");
        classifier.classifyWithAttendance(82, 80);
        System.out.print("marks = 91, attendance = 60: ");
        classifier.classifyWithAttendance(91, 60);
    }
}
