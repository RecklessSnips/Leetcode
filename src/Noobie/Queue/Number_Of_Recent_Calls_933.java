package Noobie.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Number_Of_Recent_Calls_933 {

    private Queue<Integer> queue;

    public Number_Of_Recent_Calls_933() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        while (queue.peek() < t - 3000){
            queue.remove();
        }
        return queue.size();
    }

    public static void main(String[] args) {
        Number_Of_Recent_Calls_933 call =
                new Number_Of_Recent_Calls_933();
        System.out.println(call.ping(1));
        System.out.println(call.ping(100));
        System.out.println(call.ping(3001));
        System.out.println(call.ping(3002));
    }
}
