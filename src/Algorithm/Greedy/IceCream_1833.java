package Algorithm.Greedy;

import java.util.Arrays;

public class IceCream_1833 {

    public static int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int num = 0, cost = 0;
        // greedy, buy all cheap ice creams first, as many as possible
        for (int j : costs) {
            // if the cheapest is > coins
            if (j > coins){
                return num;
            }
            int tmp = cost + j;
            if (tmp <= coins){
                cost += j;
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
//        int[] test = new int[]{7,3,3,6,6,6,10,5,9,2};
        int[] test = new int[]{1, 3, 2, 4, 1};
        Arrays.sort(test);
        System.out.println(Arrays.toString(test));
        System.out.println(test.length);

//        System.out.println(maxIceCream(test, 56));
        System.out.println(maxIceCream(test, 7));
    }
}
