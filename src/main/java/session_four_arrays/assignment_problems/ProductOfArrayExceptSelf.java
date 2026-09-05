package session_four_arrays.assignment_problems;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Forward pass: accumulate the running product of elements to the left
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Backward pass: multiply in the running product of elements to the right
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;
            rightProduct *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf solver = new ProductOfArrayExceptSelf();

        int[] nums1 = {1, 2, 3, 4};
        int[] result1 = solver.productExceptSelf(nums1);
        System.out.println("Input: " + Arrays.toString(nums1) + " -> Output: " + Arrays.toString(result1));

        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] result2 = solver.productExceptSelf(nums2);
        System.out.println("Input: " + Arrays.toString(nums2) + " -> Output: " + Arrays.toString(result2));
    }
}
