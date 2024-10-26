package Noobie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Richest_Customer_Wealth_1672 {

    public static int maximumWealth(int[][] accounts) {
        List<Integer> list = new ArrayList<>();
        int[] l = new int[2];
        for (int[] i : accounts){
            int wealth = 0;
            for (int j = 0; j < i.length ; j++){
                wealth += i[j];
            }
            list.add(wealth);
        }
        return Collections.max(list);
    }

    public static void main(String[] args) {
        System.out.println(maximumWealth(new int[][] {{1,2,3},{3,2,1}}));
    }
}
