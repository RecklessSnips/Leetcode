package Algorithm.Greedy;

public class Jump_Game_45 {

    public static int canJump(int[] nums) {
        /*
         Since as long as we jump over the last point, then we can select
         nums[i] > n-1 will be good. Then we choose the largest point from
         the starting point, we choose the 改点可以跳到的所有点里的，
         下一次可以跳最远的那个点，则为贪心算法，这样即为贪心算法，可以让我们节省
         跳的次数，并且跳到我们的中点
         */
        //左右指针是为了涵盖某点可以跳到的所有点里的范围，用来筛选最远的
        int leftPointer = 0, rightPointer = 0, max_reachable = 0, count = 0;
        // 当右指针达到了array length - 1停下（最后一个）因为假设的是只要到达倒数第二个的时候，必然可以到最后一个
        int last_position = nums.length - 1;
        while (rightPointer < last_position){
            // 选取能力最强的点, 跳
            for (; leftPointer < rightPointer+1; leftPointer++) {
                max_reachable = Math.max(max_reachable, leftPointer + nums[leftPointer]);
            }
            leftPointer = rightPointer + 1;
            rightPointer = max_reachable;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
    }
}
