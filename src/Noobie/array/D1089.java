package Noobie.array;

import java.util.Arrays;

public class D1089 {

    /*
        这个题要在不改变原来array的长度的情况下，将0复制一下，然后把之前这个位置的
        值后移，多出长度的值不算
     */
    public static void duplicateZeros(int[] arr) {
        // 每当遇到0的时候，把剩下的 arr 做一个copy，然后不断更新这个 copy
        // 1. 暴力解法，不推荐
//        int[] copy;
//
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == 0) {
//                // 防止 i++ 的时候超出范围
//                if (i + 1 < arr.length){
//                    copy = Arrays.copyOfRange(arr, i + 1, arr.length + 1);
//                    // 下一个位置为0，同时调整 i
//                    arr[++i] = 0;
//                    // 跳到下一个位置，准备把 copy 里的赋值回来
//                    i++;
//                    // 把copy里的值赋值回到原 arr
//                    int counter = 0;
//                    for (int j = i; j < arr.length; j++) {
//                        arr[j] = copy[counter];
//                        counter++;
//                    }
//                    // 因为下一轮 i 会被自动增加，这里需要退回到 copy 的头部位置，也就是 i--
//                    // 这个也保证了不会超出范围 (第44行的测试)
//                    i--;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arr));

        // 2. In Place 解法
        // 遇到一个 0 之后尾部的元素就会被去掉，那么可以从后往前来复制，直到当前这个0
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                // 从后往前开始复制, 从最后一个开始赋值
                for (int j = arr.length - 1; j > i; j--) {
                    arr[j] = arr[j - 1];
                }
                // 确保我们略过刚刚复制出来的这个0
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        duplicateZeros(new int[]{1,0,2,3,0,4,5,0});
        duplicateZeros(new int[]{1, 2, 3});
        // 验证连续的 0
        duplicateZeros(new int[]{0,4,1,0,0,8,0,0,3});
        duplicateZeros(new int[]{0});
        duplicateZeros(new int[]{1, 0, 3});
    }
}
