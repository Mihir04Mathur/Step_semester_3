package session_four_arrays.assignment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public int[][] threeSum(int[] nums) {
        Arrays.sort(nums);
        List<int[]> resultList = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    resultList.add(new int[]{nums[i], nums[left], nums[right]});

                    // Skip duplicate elements for left pointer
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicate elements for right pointer
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return resultList.toArray(new int[resultList.size()][]);
    }

    public static void main(String[] args) {
        ThreeSum solver = new ThreeSum();

        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        int[][] result1 = solver.threeSum(nums1);
        System.out.print("Input: " + Arrays.toString(nums1) + " -> Output: [");
        for (int i = 0; i < result1.length; i++) {
            System.out.print(Arrays.toString(result1[i]) + (i < result1.length - 1 ? ", " : ""));
        }
        System.out.println("]");

        int[] nums2 = {0, 0, 0};
        int[][] result2 = solver.threeSum(nums2);
        System.out.print("Input: " + Arrays.toString(nums2) + " -> Output: [");
        for (int i = 0; i < result2.length; i++) {
            System.out.print(Arrays.toString(result2[i]) + (i < result2.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}
