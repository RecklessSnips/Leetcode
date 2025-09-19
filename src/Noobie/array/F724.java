package Noobie.array;

public class F724 {

    public static int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;
        int pivot = -1;
        for (int i = 0; i < nums.length; i++) {
            // Calculate left sum
            if (i > 0) {
                // 计算pivot的左边的和
                leftSum += nums[i - 1];
            }
            // Calculate right sum
            // // 计算pivot的左边的和
            for (int j = i + 1; j < nums.length; j++) {
                rightSum += nums[j];
            }
            // 如果一样，返回
            if (leftSum == rightSum){
                pivot = i;
                return pivot;
            }else{
                // 否则下个循环再次计算
                rightSum = 0;
            }
        }
        return pivot;
    }

    /*
    🧠 解题思路提示：
    总和 - 当前数值 - 左侧和 = 右侧和

    换句话说：如果一个位置的左侧和等于右侧和，那么：

    左侧和 == 总和 - 左侧和 - 当前元素
    变一下等式的方向:
    2 * 左侧和 + 当前元素 == 总和

    从左到右遍历数组，累计左侧的和（leftSum），对每一个位置判断是否满足上面的条件。
     */
    public static int solution2(int[] nums){
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == total - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(pivotIndex(new int[]{2, -1, 1}));
        System.out.println(pivotIndex(new int[]{1, 2, 3}));
    }
}
