package functions_arrays.assigment_problems;

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
        boolean hasDuplicate1 = solver.containsDuplicate(new int[]{1, 2, 3, 1});
        System.out.println("Duplicate 1: " + hasDuplicate1);

        boolean hasDuplicate2 = solver.containsDuplicate(new int[]{1, 2, 3, 4});
        System.out.println("Duplicate 2: " + hasDuplicate2);
    }
}
