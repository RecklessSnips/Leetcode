package Medium;

import java.util.HashMap;
import java.util.Map;

public class Task_Scheduler_2365 {

    public static long taskSchedulerII(int[] tasks, int space) {
//        tasks = [1,2,1,2,3,1], space = 3
        // space + 1 + current index = start index
        Map<Integer, Integer> map = new HashMap<>();
        // counter to count the space
        int day = 0, tmp;
        for (int i : tasks){
            if(!map.containsKey(i)){
                map.put(i, day);
            }else{
                if (map.get(i) <= space){
                    day++;
                }else {
                    day = 0;
                }
            }
            day++;
        }
        System.out.println(map.entrySet());
        return day;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 1, 2, 3, 1};
        long a = taskSchedulerII(test, 3);
        System.out.println(a);

        int[] test1 = new int[]{5, 8, 8, 5};
        long a1 = taskSchedulerII(test1, 2);
        System.out.println(a1);

        int[] test2 = new int[]{5, 8};
        long a2 = taskSchedulerII(test2, 2);
        System.out.println(a2);

        int[] test3 = new int[]{8};
        long a3 = taskSchedulerII(test3, 1);
        System.out.println(a3);
    }
}
