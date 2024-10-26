package Algorithm.Greedy;

import java.util.Arrays;

public class Gas_Station_134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum())
            return -1;
        int start = 0, total_gas = 0, total_cost = 0, diff = 0;
        for (int i = 0; i < gas.length; i++) {
            diff += gas[i] - cost[i];
            if (diff < 0) {
                diff = 0;
                start = i + 1;
            }
        }
        return start;
    }
}
