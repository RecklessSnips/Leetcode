package Noobie.array;

public class M485 {

    public static int findMaxConsecutiveOnes(int[] nums) {
        // counter 来储存每一次遇到0之前的，1的总数量，然后赋值给 result
        // 当遇到下一个0的时候，将 counter 和之前储存的 result比较来取最大值
        int counter = 0, result = 0;
        for (int i : nums) {
            if (i == 0) {
                result = Math.max(counter, result);
                counter = 0;
            } else{
                counter++;
            }

        }
        // 这个是为了确保当数组里后面没有0，需要看看是遇到最后一个0之后
        // 的 1 的数量和之前储存的 result，谁大
        return Math.max(counter, result);
    }

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1}));
    }
}
