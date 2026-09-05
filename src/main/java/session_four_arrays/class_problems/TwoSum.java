package session_four_arrays.class_problems;

import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSum solver = new TwoSum();

        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solver.twoSum(nums1, target1);
        System.out.println("Input: " + Arrays.toString(nums1) + ", target = " + target1 + " -> Output: " + Arrays.toString(result1));

        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solver.twoSum(nums2, target2);
        System.out.println("Input: " + Arrays.toString(nums2) + ", target = " + target2 + " -> Output: " + Arrays.toString(result2));
    }
}
