package Noobie;

import java.util.HashMap;
import java.util.Map;

public class Two_Sum_1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numbers = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int adder = nums[i];
            int complement = target - adder;
            if (numbers.containsKey(complement)){
                return new int[] {i, numbers.get(complement)};
            }
            numbers.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {

    }
}
