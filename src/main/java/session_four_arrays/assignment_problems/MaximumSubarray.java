package session_four_arrays.assignment_problems;

import java.util.Arrays;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        // Kadane's algorithm: decide whether to extend the running subarray or restart fresh
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSubarray solver = new MaximumSubarray();

        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result1 = solver.maxSubArray(nums1);
        System.out.println("Input: " + Arrays.toString(nums1) + " -> Output: " + result1);

        int[] nums2 = {-3, -1, -2};
        int result2 = solver.maxSubArray(nums2);
        System.out.println("Input: " + Arrays.toString(nums2) + " -> Output: " + result2);
    }
}
