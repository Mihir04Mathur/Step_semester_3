package session_four_arrays.class_problems;

import java.util.Arrays;

public class RotateArray {
    public int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int n = nums.length;
        k = k % n;
        int[] newArray = new int[n];

        for (int i = 0; i < n; i++) {
            newArray[(i + k) % n] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = newArray[i];
        }

        return nums;
    }

    public static void main(String[] args) {
        RotateArray solver = new RotateArray();

        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        int[] result1 = solver.rotateArray(nums1, k1);
        System.out.println("Input: nums = [1, 2, 3, 4, 5, 6, 7], k = " + k1 + " -> Output: " + Arrays.toString(result1));

        int[] nums2 = {1, 2};
        int k2 = 3;
        int[] result2 = solver.rotateArray(nums2, k2);
        System.out.println("Input: nums = [1, 2], k = " + k2 + " -> Output: " + Arrays.toString(result2));
    }
}
