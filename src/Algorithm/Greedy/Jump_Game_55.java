package Algorithm.Greedy;


public class Jump_Game_55 {

    // solution 1
    public boolean canJump(int[] nums) {
        /*
         Since as long as we jump over the last point, then we can select
         nums[i] > n-1 will be good. Then we choose the largest point from
         the starting point, we choose the 改点可以跳到的所有点里的，
         下一次可以跳最远的那个点，则为贪心算法，这样即为贪心算法，可以让我们节省
         跳的次数，并且跳到我们的中点
         */
        int max_reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            // 我们默认一次一动一个点
            // every time check if from 上一个点，能否到达此点
            if (max_reachable < i){
                return false;
            }
            /*
               如果能到达，那么检查这个点的最远距离，贪婪地选择最远的那个
               如果没有更远的，则一直for loop到当前最远的那个，这里就是最重要的部分
               选择能力最强的那个点
            */
            max_reachable = Math.max(max_reachable, i + nums[i]);
            // if not, 到下一个点开始检查
            if (max_reachable > nums.length - 1){
                return true;
            }
        }
        return true;
    }

    // solution 2 https://www.youtube.com/watch?v=Yan0cv2cLy8
    public boolean canJump2(int[] nums){
        int goal = nums.length-1;
        // shifting
        for (int i = nums.length - 1; i >= 0 ; i--) {
            // 点的能力 = 点本身位置加上跳的距离
            if (i + nums[i] >= goal){
                // shift back
                goal = i;
            }
        }
        return goal == 0;
    }
}
