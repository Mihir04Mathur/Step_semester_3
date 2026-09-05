package session_four_arrays.class_problems;

import java.util.Arrays;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate solver = new ContainsDuplicate();

        int[] nums1 = {1, 2, 3, 1};
        boolean hasDuplicate1 = solver.containsDuplicate(nums1);
        System.out.println("Input: " + Arrays.toString(nums1) + " -> Output: " + hasDuplicate1);

        int[] nums2 = {1, 2, 3, 4};
        boolean hasDuplicate2 = solver.containsDuplicate(nums2);
        System.out.println("Input: " + Arrays.toString(nums2) + " -> Output: " + hasDuplicate2);
    }
}
