package Noobie.array;

import java.util.Arrays;

public class P66 {

    public static void main(String[] args) {
        int[] digits = new int[]{9};
        int[] ints = plusOne(digits);
        System.out.println(Arrays.toString(ints));

    }

    public static int[] plusOne(int[] digits) {
        // 加起来之后用 结果减去 10 代表新digit，然后下一位加1
        for (int i = digits.length - 1; i >= 0; i--) {
            // 如果不是9，直接+1即可
            if (digits[i] < 9){
                digits[i]++;
                return digits;
            }else{
                // 如果是9，变为0，然后下一位会判断加1
                digits[i] = 0;
            }
        }
        // if all 9
        int[] newInt = new int[digits.length + 1];
        newInt[0] = 1;
        return newInt;
    }
}
