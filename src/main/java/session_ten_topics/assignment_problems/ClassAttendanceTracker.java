package session_ten_topics.assignment_problems;

import java.util.Arrays;

public class ClassAttendanceTracker {

    /**
     * Time Complexity: O(n) in a single pass through the days array.
     * Space Complexity: O(1) auxiliary space (only a few scalar counters).
     */
    public static String attendanceSummary(int[] days) {
        if (days == null || days.length == 0) {
            return "Present: 0, Longest streak: 0";
        }

        int presentCount = 0;
        int currentStreak = 0;
        int longestStreak = 0;

        for (int day : days) {
            if (day == 1) {
                presentCount++;
                currentStreak++;
                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }

        return "Present: " + presentCount + ", Longest streak: " + longestStreak;
    }

    public static void main(String[] args) {
        int[] days1 = {1, 1, 0, 1, 1, 1, 0, 1};
        System.out.println("days = " + Arrays.toString(days1));
        System.out.println(attendanceSummary(days1));

        int[] days2 = {0, 0, 0};
        System.out.println("days = " + Arrays.toString(days2));
        System.out.println(attendanceSummary(days2));
    }
}
