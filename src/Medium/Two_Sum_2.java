package Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Two_Sum_2 {

    public static void main(String[] args) {
        int[] test = twoSum(new int[]{-1, 0}, -1);
        System.out.println(Arrays.toString(test));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] answer = new int[0];
        int length = numbers.length;
        int smallPointer = 0;
        int bigPointer = length - 1;
        while (smallPointer < bigPointer){
            int sum = numbers[smallPointer] + numbers[bigPointer];
            if (sum > target){
                bigPointer--;
            }else if (sum < target){
                smallPointer++;
            }else{
                answer = new int[]{++smallPointer, ++bigPointer};
                break;
            }
        }
        return answer;
    }
}
