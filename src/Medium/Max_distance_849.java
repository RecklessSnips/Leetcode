package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Max_distance_849 {

    // using list sort
    public static int maxDistToClosest(int[] seats) {
        int[] distance = new int[seats.length];
        List<Integer> d = new ArrayList<>();
        int left = -1;

        int right, maxDis;

        for (int i = 0; i < seats.length; i ++){
            if (seats[i] == 1){

                    // {0, 0, 1, 0, 0, 0, 0}
                    if (left == -1 && i != 0) {
                        left = i;
                        maxDis = left;
                        d.add(maxDis);
                    }// {1, 0, 0, 1, 1, 0, 1}
                    else if (left == -1) {
                        left = 0;
                        maxDis = 0;
                        d.add(maxDis);
                    }// {0, 0, 0, 1, 1, 0, 1}
                    // {1, 0, 0, 0, 1, 0, 1}
                    else {
                        right = i;
                        maxDis = (right - left) / 2;
                        d.add(maxDis);
                        left = right;
                    }
            }else{
                if (i == seats.length - 1) {
                    maxDis = (i - left);
                    d.add(maxDis);
                }
            }
        }
        // last
        if (left == 0){
            maxDis = seats.length - 1;
            d.add(maxDis);
        }

        Collections.sort(d);

        System.out.println(d.toString());
        return d.get(d.size() - 1);
    }

    public static int maxDistToClosest2(int[] seats) {
        int[] distance = new int[seats.length];
        int left = -1;

        int right, maxDis = 0, tmp;

        for (int i = 0; i < seats.length; i ++){
            if (seats[i] == 1){
                // {0, 0, 1, 0, 0, 0, 0}
                if (left == -1 && i != 0) {
                    left = i;
                    tmp = left;
                    maxDis = Math.max(tmp, maxDis);
                }// {1, 0, 0, 1, 1, 0, 1}
                else if (left == -1) {
                    left = i;
                    tmp = 0;
                    maxDis = Math.max(tmp, 0);
                }// {0, 0, 0, 1, 1, 0, 1}
                // {1, 0, 0, 0, 1, 0, 1}
                else {
                    right = i;
                    tmp = (right - left) / 2;
                    maxDis = Math.max(maxDis, tmp);
                    left = right;
                }
            }else{
                if (i == seats.length - 1) {
                    tmp = (i - left);
                    maxDis = Math.max(tmp, maxDis);
                }
            }

//            System.out.println(maxDis + "hi");
        }
        // last
        if (left == 0){
            tmp = seats.length - 1;
            maxDis = Math.max(tmp, maxDis);
        }
        return maxDis;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,0,0,0,1,0,1, 0, 0, 1};
        int res;
        res = maxDistToClosest2(test);
        System.out.println(res);

        int[] test1 = new int[]{1, 0, 0, 0};
        int res1;
        res1 = maxDistToClosest2(test1);
        System.out.println(res1);

        int[] test2 = new int[]{1, 0, 1};
        int res2;
        res2 = maxDistToClosest2(test2);
        System.out.println(res2);

        int[] test3 = new int[]{0, 1, 0, 0, 0, 0};
        int res3;
        res3 = maxDistToClosest2(test3);
        System.out.println(res3);
    }
}
