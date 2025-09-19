package Noobie.array;

public class R27 {

    /*
    Change the array nums such that the first k elements of nums contain the elements which are not equal to val.
    The remaining elements of nums are not important as well as the size of nums.
     */
    public static int removeElement(int[] nums, int val) {
        // 把所有的 val 换到最后
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                // 遇到第一个不是 val 的值，与 val 交换位置
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != nums[i]) {
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                        break;
                        // 只交换第一个不相同的，然后立马下一个循环找下一个
                    }
                }
            }
        }

        int k = 0;

        // 数 val 出现了多少次
        for (int num : nums) {
            if (num != val) {
                k++;
            }else {
                break;
            }
        }

        return k;

        // 更简单方法：
        // 下一个有效位置
//        int k = 0;
//        for (int num : nums) {
//            if (num != val) {
//                nums[k++] = num;
//            }
//        }
//        return k;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 3));
    }
}
