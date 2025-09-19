package Noobie.array;

import java.util.Arrays;

public class M88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        /*
         利用两个pointer，分别指向两个数组, nums1 -> a1, nums2 -> a2，并且时刻对比它们的大小
         还需要创建一个大小为 m+n 的数组命名 copy ，来储存结果，最后复制给数组1（或者可以吧数组1的数字先拿出来）
         用 p3 作为 copy 的 pointer， 负责写入

         以指针2 < 数组2长度 为停止条件，开始遍历：
         1. 如果 a1 = a2, 那么就在 copy 的对应位置和下一个位置添加这个数字，两个指针都增加
         2. 如果 a1 < a2, 先增加 a1，然后a2，然后增加指针1
         3. 如果 a1 > a2, 先增加 a2，然后a1，然后增加指针2
        */

//        int[] copy = new int[m + n];
//        int p1 = 0, p2 = 0, p3 = 0;
//        while (p2 < n){
//            if (nums1[p1] == nums2[p2]) {
//                copy[p3++] = nums1[p1];
//                copy[p3] = nums2[p2];
//                p1++;
//                p2++;
//            } else if (nums1[p1] < nums2[p2]) {
//                if (nums1[p1] == 0){
//                    copy[p3] = nums2[p2];
//                    p2++;
//                }else{
//                    copy[p3] = nums1[p1];
//                    p1++;
//                }
//            } else {
//                copy[p3] = nums2[p2];
//                p2++;
//            }
//            p3++;
//        }
//
//        System.arraycopy(copy, 0, nums1, 0, m + n);

        // 2. GPT 增强版，延续这个思路
//        int[] copy = new int[m + n];
//        // 非常重要！三个 pointer！
//        int p1 = 0, p2 = 0, p3 = 0;
//
//        // 关键修正1：同时受 m、n 约束，避免越界
//        while (p1 < m && p2 < n) {
//            if (nums1[p1] == nums2[p2]) {
//                copy[p3++] = nums1[p1++];
//                copy[p3++] = nums2[p2++];
//            } else if (nums1[p1] < nums2[p2]) {
//                copy[p3++] = nums1[p1++];
//            } else {
//                copy[p3++] = nums2[p2++];
//            }
//        }
//
//        // 关键修正2：把剩余的一边补齐, 这时候不知道哪一边跑完了，所以再次用 p1 < m 和 < n 的逻辑检验没跑完的一边
//        // 所以这俩先写谁无所谓, 将剩下的全部放进来即可
//        while (p1 < m) copy[p3++] = nums1[p1++];
//        while (p2 < n) copy[p3++] = nums2[p2++];
//
//        // 关键修正3：覆写原 nums1（不要改引用）
//        System.arraycopy(copy, 0, nums1, 0, m + n);
//
//        System.out.println(Arrays.toString(nums1));

//        3. 还有 in place 的写法，不需要额外 copy，从而后往前！当然也是 3个 pointer，非常好！

        int p1 = m - 1, p2 = n - 1, p3 = m + n - 1;

        // 从末尾来填写，因为nums1的剩余部分是从nums2直接来的，直接往里填就行
        // 条件是 p2 必须填写完
        while(p2 >= 0){
            // 每次必须查看 p1 是否还可以填
            if (p1 >= 0 && nums1[p1] == nums2[p2]){
                nums1[p3--] = nums1[p1--];
                nums1[p3--] = nums2[p2--];
            } else if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p3--] = nums1[p1--];
            } else {
                // 如果 p1 填满了把剩下的 p2 全部填进来，等 p2 填完就结束了
                nums1[p3--] = nums2[p2--];
            }
        }

        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
//        merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
//        merge(new int[]{1}, 1, new int[]{}, 0);
        merge(new int[]{0}, 0, new int[]{1}, 1);
    }
}
