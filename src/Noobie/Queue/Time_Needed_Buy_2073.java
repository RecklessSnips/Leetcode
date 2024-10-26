package Noobie.Queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Time_Needed_Buy_2073 {

    class Person{
        int index;
        int tickets;

        Person(int i, int t){
            index = i;
            tickets = t;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "index=" + index +
                    ", tickets=" + tickets +
                    '}';
        }
    }

    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Person> queue = new LinkedList<>();
        int time = 0;
        for (int i = 0; i < tickets.length; i++) {
            queue.add(new Person(i, tickets[i]));
        }
        while (!queue.isEmpty()){
            Person person = queue.remove();
            person.tickets--;
            time++;
            if (person.tickets > 0){
                queue.add(person);
            }else if (person.tickets == 0 && person.index == k){
                break;
            }
        }
        return time;
    }

    public static void main(String[] args) {
        Time_Needed_Buy_2073 s =
                new Time_Needed_Buy_2073();
        System.out.println(s.timeRequiredToBuy(new int[]{5, 1, 1, 1}, 0));
    }
}
