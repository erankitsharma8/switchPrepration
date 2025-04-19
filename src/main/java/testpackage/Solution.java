package testpackage;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] nums, int start) {
        if (start == nums.length) {
            // Convert array to list and add to result
            List<Integer> currentPermutation = new ArrayList<>();
            for (int num : nums) {
                currentPermutation.add(num);
            }
            result.add(currentPermutation);
        } else {
            for (int i = start; i < nums.length; i++) {
                // Swap nums[start] with nums[i]
                swap(nums, start, i);
                // Recur for the next index
                backtrack(result, nums, start + 1);
                // Backtrack (undo the swap)
                swap(nums, start, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = solution.permute(nums);
        System.out.println(permutations);
    }
}

