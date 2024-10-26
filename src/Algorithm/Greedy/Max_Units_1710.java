package Algorithm.Greedy;

import java.util.Arrays;

public class Max_Units_1710 {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        // maximum units
        int res = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            while (boxTypes[i][0] > 0 && truckSize > 0){
                res += boxTypes[i][1];
                boxTypes[i][0]--;
                truckSize--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] costs = new int[]{10,6,8,7,7,8};
        Arrays.sort(costs);
        System.out.println(Arrays.toString(costs));
    }
}
