package functions_arrays.assigment_problems;

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
        int[] result1 = solver.rotateArray(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        System.out.print("Result 1: [");
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i] + (i < result1.length - 1 ? ", " : ""));
        }
        System.out.println("]");

        int[] result2 = solver.rotateArray(new int[]{1, 2}, 3);
        System.out.print("Result 2: [");
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i] + (i < result2.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}
