package session_four_arrays.assignment_problems;

import java.util.Arrays;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // The minimum element must be strictly in the right half
                left = mid + 1;
            } else {
                // The minimum element is at mid or in the left half
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray solver = new FindMinimumInRotatedSortedArray();

        int[] nums1 = {3, 4, 5, 1, 2};
        int result1 = solver.findMin(nums1);
        System.out.println("Input: " + Arrays.toString(nums1) + " -> Output: " + result1);

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int result2 = solver.findMin(nums2);
        System.out.println("Input: " + Arrays.toString(nums2) + " -> Output: " + result2);

        int[] nums3 = {11, 13, 15, 17};
        int result3 = solver.findMin(nums3);
        System.out.println("Input: " + Arrays.toString(nums3) + " -> Output: " + result3);
    }
}
