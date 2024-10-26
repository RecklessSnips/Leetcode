package Noobie;

public class Single_Number_136 {

    public static int singleNumber(int[] nums) {
        int num = 0, bestcount = 0, count = 0;;
        if (nums.length == 1){
            return nums[nums.length-1];
        }
        for (int i = 0; i < nums.length; i++) {
            num = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if (num == nums[j]){
                    count++;
                }else {
                    bestcount = i;
                }
            }
        }

        System.out.println(count);
        return nums[bestcount];
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2}));
    }
}
