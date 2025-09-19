package Noobie.array;

import java.util.Arrays;

public class R189 {

    /*
    ### 🧩 问题本质：右移数组元素

    假设我们有一个数组：
    `nums = [1, 2, 3, 4, 5, 6, 7]`，`k = 3`，我们想得到：
    ➡️ `[5, 6, 7, 1, 2, 3, 4]`

    我们思考一个问题：

    > 如果我们能把 `[1, 2, 3, 4]` 和 `[5, 6, 7]` 的位置“整体调换”，是不是就能完成？

    也就是说：

    * 把最后的 3 个数 `[5, 6, 7]` 变到前面
    * 把前面的 4 个数 `[1, 2, 3, 4]` 放到后面

    但直接“整体调换”两个子数组比较复杂。于是我就问自己：

    ---

    ### 💡 有没有一个简单的操作能实现这种“块交换”？

    我们发现：

    > 反转两个部分，然后再反转整体，是可以实现调换顺序的！

    比如我们反转 `A = [1, 2, 3, 4]` → `[4, 3, 2, 1]`，
    再反转 `B = [5, 6, 7]` → `[7, 6, 5]`，
    把两个拼成 `[4, 3, 2, 1, 7, 6, 5]`，再反转整个数组 → `[5, 6, 7, 1, 2, 3, 4]`，正是我们想要的！

    ---

    ### 🧠 总结这个“逆推”的逻辑：

    1. 想象目标结果：右移后的数组是什么样子？
    2. 观察其中的结构变化：哪些部分移动到前面？哪些到后面？
    3. 如果直接交换困难，就考虑“反转 + 拼接”的方式（因为反转是最基础、最容易实现的数组操作）
    4. 把这个思路推广成三步反转


     */
    public static void rotate(int[] nums, int k) {
        /*
        因为k有可能会超出数组的范围，所以可以取模: k % length（modulo是一个很神奇的技巧，详情见modulo篇章), 这个 mod 结果就是要反转的次数
        也就是数组后面的 mod个数：1.反转 2. 然后放到数组前面
        比如: [1, 2, 3, 4], k = 6
        那么 6 % 4 = 2，
        1. [4, 1, 2, 3]
        2. [3, 4, 1, 2] ---> same as the 6 time
        3. [2, 3, 4, 1]
        4. [1, 2, 3, 4]
        5. [4, 1, 2, 3]
        6. [3, 4, 1, 2] ---> same as the 2 time

        那么可以现将后面 mod 个反转，然后拼接到前面就可以，这就需要 partial 反转

        跟高效的是，因为是两个部分，我们可以整体反转之后，单独反转这两个部分
         */

        int rotateTimes = k % nums.length;

        // 整体反转
        partialReverse(0, nums.length - 1, nums);
        // 将前面的k个反转
        partialReverse(0, rotateTimes - 1, nums);
        // 将后面的反转
        partialReverse(rotateTimes, nums.length - 1, nums);

        System.out.println(Arrays.toString(nums));
    }

    private static int[] partialReverse(int start, int end, int[] nums){
        // Reverse the array in place
        while (start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;

            start ++;
            end--;
        }
        return nums;
    }

    public static void main(String[] args) {
        rotate(new int[]{-1, -100, 3, 99}, 2);
    }
}
