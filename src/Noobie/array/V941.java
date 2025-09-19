package Noobie.array;

public class V941 {

    /*
        题目说的很不明确。
        需要注意：一直上升或者一直下降都不行，所以要设置flag
     */
    public static boolean validMountainArray(int[] arr) {
        /*
         1. 方法1: 直接办法，从左边判断是否一直在上升，遇到相同的直接返回 false
            如果遇到第一个小的，说明到达了山顶，那么转到第二个循环去判断是否一直在下降

            每个都要判断是否在一直在下降或者上升，否则报错
         */
        if (arr.length < 3) return false;
//
//        int mountainTop = 0;
//        boolean isIncreasing = false, isDecreasing = false;
//
//        for (int i = 0; i < arr.length - 1; i++) {
//            if (arr[i] == arr[i + 1]) {
//                return false;
//            } else if (arr[i] > arr[i + 1]) {
//                // 找到 “山顶” 了
//                mountainTop = i;
//                break;
//            } else {
//                isIncreasing = true;
//            }
//        }
//
//        // 第二个循环，判断是否在下降
//        for (int i = mountainTop; i < arr.length - 1; i++) {
//            if (arr[i] < arr[i + 1]) {
//                return false;
//            } else if (arr[i] == arr[i + 1]) {
//                return false;
//            } else {
//                isDecreasing = true;
//            }
//        }
//
//        return isIncreasing && isDecreasing;

        // 2. 方法2：使用首尾两个指针，对撞指针，如果他们能相遇，说明是

        /*
         当两个指针相遇，就结束。但如果中途它们遇到了相等或者不正确的路线，
         那么就报错
         */
        int n = arr.length;

        int head = 0, tail = n - 1;

        // 从左边严格上升：head 指到“峰顶”
        while (head + 1 < n && arr[head] < arr[head + 1]) {
            head++;
        }

        // 从右边严格下降：tail 指到“峰顶”
        while (tail - 1 >= 0 && arr[tail] < arr[tail - 1]) {
            tail--;
        }

        // 峰顶不能在两端，且两边爬到的是同一个峰
        return head > 0 && tail < n - 1 && head == tail;
    }

    public static void main(String[] args) {
        System.out.println(validMountainArray(new int[]{2, 1}));
        System.out.println(validMountainArray(new int[]{3, 5, 5}));
        System.out.println(validMountainArray(new int[]{0, 3, 2, 1}));
        System.out.println(validMountainArray(new int[]{2, 0, 2}));
    }
}
