package session_ten_topics.assignment_problems;

import java.util.Arrays;

public class ExamScoreBandCounter {

    // Binary search for first index with score >= target
    public static int lowerBound(int[] scores, int target) {
        int left = 0, right = scores.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // Binary search for first index with score > target
    public static int upperBound(int[] scores, int target) {
        int left = 0, right = scores.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * Time Complexity: O(log n) using binary search (lowerBound and upperBound).
     * Linear scan would take O(n), which is too slow for 10^6 scores.
     * Space Complexity: O(1) auxiliary space.
     * Edge duplicates are naturally handled by finding the first index >= low
     * and the first index strictly > high.
     */
    public static int countInBand(int[] scores, int low, int high) {
        if (scores == null || scores.length == 0 || low > high) {
            return 0;
        }
        int firstIndex = lowerBound(scores, low);
        int afterLastIndex = upperBound(scores, high);
        return afterLastIndex - firstIndex;
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};

        int count1 = countInBand(scores, 42, 58);
        System.out.println("scores = " + Arrays.toString(scores) + ", low = 42, high = 58");
        System.out.println("Expected: 6, Got: " + count1);

        int count2 = countInBand(scores, 90, 100);
        System.out.println("scores = " + Arrays.toString(scores) + ", low = 90, high = 100");
        System.out.println("Expected: 0, Got: " + count2);
    }
}
