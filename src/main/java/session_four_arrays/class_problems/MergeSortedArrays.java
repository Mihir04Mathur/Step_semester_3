package session_four_arrays.class_problems;

import java.util.Arrays;

public class MergeSortedArrays {
    public int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        MergeSortedArrays solver = new MergeSortedArrays();

        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        int[] result1 = solver.mergeSortedArrays(arr1, arr2);
        System.out.println("Input: " + Arrays.toString(arr1) + ", " + Arrays.toString(arr2) + " -> Output: " + Arrays.toString(result1));

        int[] arr3 = {};
        int[] arr4 = {1, 2, 3};
        int[] result2 = solver.mergeSortedArrays(arr3, arr4);
        System.out.println("Input: " + Arrays.toString(arr3) + ", " + Arrays.toString(arr4) + " -> Output: " + Arrays.toString(result2));
    }
}
