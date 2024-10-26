package Noobie.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Two_Queue_Stack_225 {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public Two_Queue_Stack_225() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // 给空的那个queue加，因为要保证每一次stack有活动，并且两个queue交换完数据
    // 之后，下一次stack的活动就能有地方开始。
    /*
     比如:
     Operation 1: stack.push(1), push(2)
      Q1: 1 2
      Q2:
     Operation 2: stack.peek(): 需要拿取Q1的末尾，则需要将整个queue除了最后一位，转移到Q2去
     Q1: 2
     Q2: 1
     转移完成，再把最后那个数转移到Q2，保证下一次的活动能够直到从哪个Queue开始
     Q1:
     Q2: 1 2
     Operation 3: stack.pop() 因为我们有一个queue是空的，说明我们要pop的是那个
     有数据的
     Q1:
     Q2: 1 2
     先转移数据，除了最后一个：
     Q1: 1
     Q2: 2
     pop之后：
     Q1: 1
     Q2:
     这样，下次再进行任何活动，都知道从哪个queue开始

     总结：
     Push：加到不是empty里的，刚开始的时候加到Q1即可
     Pop：把数据从非empty，转移到另一个，pop剩下的即可
     Peek：把数据从非empty，转移到另一个，peek最后一个，最后将这个放到另外一个queue里
     Empty：判断当前stack是否为空，直接交叉判断即可
     */
    public void push(int x) {
        if (q2.isEmpty()){
            q1.add(x);
        }else{
            q2.add(x);
        }
        System.out.println("q1: " + q1);
        System.out.println("q2: " + q2);
    }

    // 这时候需要选择
    public int pop() {
        int value = 0;
        if (q2.isEmpty()){
            // 注意这里！！！
            // 必须要把size储存起来，否则每次运行q1.size(), 都会重新指向
            // 但是我们已经pop了，就会导致没有pop干净！
            int size = q1.size() - 1;
            for (int i = 0; i < size; i++) {
                q2.add(q1.remove());
            }
            value = q1.remove();
            System.out.println("After pop q1: " + q1);
        }else{
            int size = q2.size() - 1;
            for (int i = 0; i < size; i++) {
                q1.add(q2.remove());
            }
            value = q2.remove();
            System.out.println("After pop q2: " + q2);
        }
        return value;
    }

    public int top() {
        int value = 0;
        if (q2.isEmpty()){
            int size = q1.size() - 1;
            for (int i = 0; i < size; i++) {
                q2.add(q1.remove());
            }
            value = q1.peek();
            q2.add(q1.remove());
        }else{
            int size = q2.size() - 1;
            for (int i = 0; i < size; i++) {
                q1.add(q2.remove());
            }
            value = q2.peek();
            q1.add(q2.remove());
        }
        return value;
    }

    public boolean empty() {
        if (q2.isEmpty()){
            return q1.isEmpty();
        }
        return false;
    }

    public static void main(String[] args) {
        Two_Queue_Stack_225 stack225 = new Two_Queue_Stack_225();
        stack225.push(1);
        stack225.push(2);
        stack225.push(3);
        stack225.push(4);
        stack225.pop();
        stack225.pop();
        stack225.pop();
        stack225.push(5);
        System.out.println("Top is: " + stack225.top());
        System.out.println(stack225.empty());
        stack225.pop();
        System.out.println(stack225.empty());
        stack225.pop();
        System.out.println(stack225.empty());
    }
}
