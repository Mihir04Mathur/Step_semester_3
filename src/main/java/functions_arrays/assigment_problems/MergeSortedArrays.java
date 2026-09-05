package functions_arrays.assigment_problems;

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
        int[] result1 = solver.mergeSortedArrays(new int[]{1, 3, 5}, new int[]{2, 4, 6});
        System.out.print("Result 1: [");
        for (int x = 0; x < result1.length; x++) {
            System.out.print(result1[x] + (x < result1.length - 1 ? ", " : ""));
        }
        System.out.println("]");

        int[] result2 = solver.mergeSortedArrays(new int[]{}, new int[]{1, 2, 3});
        System.out.print("Result 2: [");
        for (int x = 0; x < result2.length; x++) {
            System.out.print(result2[x] + (x < result2.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}
