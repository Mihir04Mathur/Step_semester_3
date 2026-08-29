package control_flow.assigment_problems;

public class LoginSimulator {
    public void simulateLogin(String correctCode, String[] attempts) {
        boolean accessGranted = false;
        for (int i = 0; i < attempts.length && i < 3; i++) {
            if (attempts[i].equals(correctCode)) {
                System.out.println("Access granted on attempt " + (i + 1));
                accessGranted = true;
                break;
            }
        }
        if (!accessGranted) {
            System.out.println("Access denied — all attempts used");
        }
    }

    public static void main(String[] args) {
        LoginSimulator simulator = new LoginSimulator();
        System.out.print("correctCode = \"1234\", attempts = {\"0000\", \"1234\", \"9999\"}: ");
        simulator.simulateLogin("1234", new String[]{"0000", "1234", "9999"});
        System.out.print("correctCode = \"1234\", attempts = {\"1111\", \"2222\", \"3333\"}: ");
        simulator.simulateLogin("1234", new String[]{"1111", "2222", "3333"});
    }
}
