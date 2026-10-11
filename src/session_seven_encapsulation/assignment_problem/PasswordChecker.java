package session_seven_encapsulation.assignment_problem;

public class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password = (password != null) ? password : "";
    }

    public String getStrength() {
        int len = password.length();
        if (len < 6) {
            return "Weak";
        } else if (len <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    public static void main(String[] args) {
        PasswordChecker pc = new PasswordChecker("abcd");
        System.out.println("pc.getStrength() -> \"" + pc.getStrength() + "\"");

        PasswordChecker pc2 = new PasswordChecker("abcdefghij");
        System.out.println("pc2.getStrength() -> \"" + pc2.getStrength() + "\"");

        PasswordChecker pc3 = new PasswordChecker("abcdef");
        System.out.println("pc3.getStrength() -> \"" + pc3.getStrength() + "\"");
    }
}
