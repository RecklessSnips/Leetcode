package Noobie.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class F448 {

    /*
        这个题很刁钻，可以参考：https://www.youtube.com/watch?v=8i-f24YFWC4

        主要思路是：
        1. 将 1 - n 这个范围里的数，map 到这个 array 的 index 上
        2. 比如 1 对应 index 0， 3 对应 index 2，因为长度一样
        3. 因为一个数字只能出现一次，所以必然有重复的，我们只关注重复的位置就行
        4. 重复的位置的 index + 1 就是确实的数字
        5. 如何找到重复的数字？（这里很刁钻）可以把 input array 的数字的值，
            到这个 值-1 的 index 上，把那个值变成负数
        6. 为什么可以“标为负数”
        假设我们有一个数字 x
        它本该出现在数组的索引 x - 1 上（0-based）。
        我们不移动它，而是在这个位置 打一个标记（比如把该位置的值变负），表示 “数字 x 出现过”。
        如果之后再遇到相同的数字 x，就会再次去找 x-1，发现它已经是负的，就知道这个数字已经标记过了。
        7. 为什么“没有变化”的位置就是缺失值
        遍历完后：
        如果一个数字 y 出现过，那么 nums[y-1] 一定会被我们变成负数（因为我们去标记它的位置）。
        如果一个数字 y 没出现过，那么 nums[y-1] 永远不会被访问，自然不会被标记，依然是正数。
        于是：
        正数位置的 index + 1 就是缺失的数字
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {

        for(int n: nums) {
            int index = Math.abs(n) - 1;
            nums[index] = -Math.abs(nums[index]);
        }

        System.out.println(Arrays.toString(nums));

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
        System.out.println(findDisappearedNumbers(new int[]{1,1}));
    }
}
