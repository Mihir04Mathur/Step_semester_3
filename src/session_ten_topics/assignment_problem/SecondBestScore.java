package session_ten_topics.assignment_problem;

import java.util.Arrays;

public class SecondBestScore {

    /**
     * Time Complexity: O(n) single pass, visiting each score once.
     * Comparing with sorting: Sorting costs O(n log n) time, whereas a single
     * pass finds the second distinct maximum in strictly linear O(n) time.
     * Space Complexity: O(1) auxiliary space without modifying the array.
     */
    public static int secondHighest(int[] scores) {
        if (scores == null || scores.length < 2) {
            return -1;
        }

        int highest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int score : scores) {
            if (score > highest) {
                second = highest;
                highest = score;
            } else if (score < highest && score > second) {
                second = score;
            }
        }

        return (second == Integer.MIN_VALUE) ? -1 : second;
    }

    public static void main(String[] args) {
        int[] scores1 = {45, 78, 92, 78, 60};
        System.out.println("scores = " + Arrays.toString(scores1));
        System.out.println("Expected: 78, Got: " + secondHighest(scores1));

        int[] scores2 = {50, 50, 50};
        System.out.println("scores = " + Arrays.toString(scores2));
        System.out.println("Expected: -1, Got: " + secondHighest(scores2));
    }
}
