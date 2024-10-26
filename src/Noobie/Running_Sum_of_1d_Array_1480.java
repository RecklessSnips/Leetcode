package Noobie;

import java.util.Arrays;

public class Running_Sum_of_1d_Array_1480 {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(runningSum(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(runningSum(new int[]{1,1,1,1,1})));
    }

    public static int[] runningSum(int[] nums) {
        int[] answer = new int[nums.length];
        // my solution
//        int tmp = 0;
//        for (int  i = 0 ; i<nums.length; i++){
//            answer[i] = nums[i] + tmp;
//            tmp = answer[i];
//        }
//        return answer;
        //or the standard solution
        for (int  i = 1 ; i<nums.length; i++){
            nums[i] = nums[i] + nums[i-1];
        }
        return nums;
    }

}
