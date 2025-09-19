package Noobie.array;

public class T414 {

    public static int thirdMax(int[] nums) {
        // sort需要 nlogn 时间，但我们要 O(n) 时间
        // Idea: 每次进来一个数，同时维护前三大的数，然后每更新一次，调整这三个数的大小
        // first，second，third 分别对应 第一大，第二大，第三大

        // 用long是为了防止 test case 用 MIN_VALUE
        // 正常情况下用 int 的 -1 就可以
        long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;
        for (int x : nums) {
            if ((long) x == first || (long) x == second || (long) x == third) continue;

            if ((long) x > first) {
                third = second; second = first; first = x;
            } else if ((long) x > second) {
                third = second; second = x;
            } else if ((long) x > third) {
                third = x;
            }
        }
        return third == Long.MIN_VALUE ? (int)first : (int)third;
    }

    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{3,2,1}));
        System.out.println(thirdMax(new int[]{1, 2}));
        System.out.println(thirdMax(new int[]{2, 2, 3, 1}));
    }
}
