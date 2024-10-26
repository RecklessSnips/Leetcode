package Noobie;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Buy_Two_Chocolates {

    public static void main(String[] args) {
//        int test = buyChoco(new int[]{1, 2, 2}, 3);
//        int test = buyChoco(new int[]{3, 2, 3}, 3);
        int test = buyChoco(new int[]{98,54,6,34,66,63,52,39}, 62);
        System.out.println(test);
    }

    public static int buyChoco(int[] prices, int money) {
        int l = 0;
        int r = prices.length - 1;
        Arrays.sort(prices);
        System.out.println(Arrays.toString(prices));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        while (l < r) {
            int sum = prices[l] + prices[r];

            if (sum < money) {
                maxHeap.add(sum);
                System.out.println(sum);
                l++;
            } else if (sum > money) {
                r--;
            } else {
                maxHeap.add(sum);
                System.out.println(sum);
                r--;
            }
        }

        int left;

        if (maxHeap.isEmpty()) {
            left = money;
        } else {
            left = money - maxHeap.peek();
            while (!maxHeap.isEmpty()) {
                System.out.print(maxHeap.poll() + "  \n");
            }
        }

        return left;
    }
}
