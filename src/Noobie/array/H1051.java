package Noobie.array;

import java.util.Arrays;

public class H1051 {

    public static int heightChecker(int[] heights) {
        int[] sorted = heights.clone();
        Arrays.sort(sorted);
        int diff = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != sorted[i]) diff++;
        }
        return diff;
    }

    public static void main(String[] args) {
        System.out.println(heightChecker(new int[]{1,1,4,2,1,3}));
    }
}
