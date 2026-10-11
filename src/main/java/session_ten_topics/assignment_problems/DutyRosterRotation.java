package session_ten_topics.assignment_problems;

import java.util.Arrays;

public class DutyRosterRotation {

    /**
     * Time Complexity: O(n) where n is the number of names.
     * Space Complexity: O(n) to store and return the newly rotated roster.
     * Rotating one place at a time k times takes O(k * n) time.
     * When k is up to 10^9, that approach would perform ~10^11 operations and time out.
     * Computing k % n collapses the rotations to at most n - 1 moves in O(n) total time.
     */
    public static String[] rotateRoster(String[] names, long k) {
        if (names == null || names.length == 0) {
            return names;
        }

        int n = names.length;
        int shift = (int) (k % n);
        String[] rotated = new String[n];

        for (int i = 0; i < n; i++) {
            rotated[(i + shift) % n] = names[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        String[] names1 = {"A", "B", "C", "D", "E"};
        System.out.println("names = [A, B, C, D, E], k = 2");
        System.out.println("Result: " + Arrays.toString(rotateRoster(names1, 2)));

        String[] names2 = {"A", "B", "C", "D", "E"};
        System.out.println("names = [A, B, C, D, E], k = 7");
        System.out.println("Result: " + Arrays.toString(rotateRoster(names2, 7)));
    }
}
