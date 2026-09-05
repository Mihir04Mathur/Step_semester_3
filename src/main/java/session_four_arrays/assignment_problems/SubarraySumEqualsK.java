package session_four_arrays.assignment_problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumFreq = new HashMap<>();
        // Base case: a prefix sum of 0 occurs once before considering any elements
        prefixSumFreq.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;

            // If (currentSum - k) exists in the map, add its frequency
            if (prefixSumFreq.containsKey(currentSum - k)) {
                count += prefixSumFreq.get(currentSum - k);
            }

            prefixSumFreq.put(currentSum, prefixSumFreq.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK solver = new SubarraySumEqualsK();

        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        int result1 = solver.subarraySum(nums1, k1);
        System.out.println("Input: nums = " + Arrays.toString(nums1) + ", k = " + k1 + " -> Output: " + result1);

        int[] nums2 = {1, -1, 0};
        int k2 = 0;
        int result2 = solver.subarraySum(nums2, k2);
        System.out.println("Input: nums = " + Arrays.toString(nums2) + ", k = " + k2 + " -> Output: " + result2);
    }
}
