package control_flow.assigment_problems;

public class VotingEligibilityChecker {
    public void checkVotingEligibility(int age) {
        boolean isEligible = age >= 18;
        if (isEligible) {
            System.out.println("Eligible to vote");
        } else {
            System.out.println("Not eligible to vote");
        }
    }

    public static void main(String[] args) {
        VotingEligibilityChecker checker = new VotingEligibilityChecker();
        System.out.print("age = 20: ");
        checker.checkVotingEligibility(20);
        System.out.print("age = 16: ");
        checker.checkVotingEligibility(16);
    }
}
