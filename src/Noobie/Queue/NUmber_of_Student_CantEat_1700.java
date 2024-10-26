package Noobie.Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NUmber_of_Student_CantEat_1700 {

    /*
    student数组里，对应的是每个学生爱吃的种类，用0，1表示，
    sandwiches数组里的代表的是🥪的种类

    如果学生爱吃，那么从queue里取出，如果没有，重新放进queue
     */

    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        // 记录何时返回，因为所有的学生都不喜欢当前的🥪
        int counter = 0;

        // 建立student的queue
        for (int j : students) {
            queue.add(j);
        }

        // 来循环 🥪
        int i = 0;
        // 循环条件：counter小于当前学生数（有人吃不上），还有学生数不为 0 （所有人都吃上了）
        while (!queue.isEmpty() && counter < queue.size()){
            if (queue.peek() == sandwiches[i]){
                // 如果吃上了，更新sandwich的位置，并且将学生移除队列，并且reset counter （因为之前可能把这个学生算作吃不上了）
                queue.remove();
                i++;
                counter = 0;
            }else{
                counter++;
                queue.add(queue.remove());
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        NUmber_of_Student_CantEat_1700 n =
                new NUmber_of_Student_CantEat_1700();
        System.out.println(n.countStudents(new int[]{1,1,1,0,0,1}, new int[]{1,0,0,0,1,1}));
    }
}
