package Noobie.array;

import java.util.Arrays;

public class R26 {

    public static int removeDuplicates(int[] nums) {
        int k = 0;
        /*
         利用跟 27 题类似的思想，我们只需要把符合条件的数字转移到前面就行
         利用 k 这个pointer，一直维护一个当前未重复的数的位置，当 for
         循环略过所有重复的值，增加 k，然后把新的值写到 k 的位置上，这样就可以
         不断的找到新的值，然后同时利用 k 来写。俗称快慢指针
         最后 k 需要 +1 因为开头的 k 必须算上
         如果想要得到去重后的数组，那就做一个 arraycopy，从 0 到 k 的位置

         */
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[k]) {
                nums[++k] = nums[i];
            }
        }

        System.out.println(Arrays.toString(nums));

        return k + 1;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,2}));
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4   }));
    }
}
