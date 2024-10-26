package Noobie;

public class Search_Insert_Position_35 {

    public int searchInsert(int[] nums, int target) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target){
                index  = i;
                break;
            }else if (i == nums.length-1 && index == 0){
                index = nums.length;
            }
        }
        return index;
    }
}
