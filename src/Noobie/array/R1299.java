package Noobie.array;

import java.util.Arrays;

public class R1299 {

    public static int[] replaceElements(int[] arr) {

        // 从右往左，因为只需要把当前值跟右边最大值做对比，所以维护好最大值即可

        int max = 0;

        for (int i = arr.length - 1; i > -1 ; i--) {
            /*
             因为要与右边最大值，所以在下一轮比较之前
             把当前位置保存下来，先赋值，然后再重新比较新的最大值
             */

            int tmp = arr[i];
            arr[i] = max;
            max = Math.max(max, tmp);
        }

        arr[arr.length - 1] = -1;

        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(replaceElements(new int[]{17, 18, 5, 4, 6, 1})));
    }
}
