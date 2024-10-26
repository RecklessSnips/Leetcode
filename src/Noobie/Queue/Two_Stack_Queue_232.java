package Noobie.Queue;

import java.util.Stack;

public class Two_Stack_Queue_232 {

    /*
    跟两个queue实现stack一样，都是来回交换stack之间的数据
    但是，因为queue一直要往tail加，而且stack被操作之后的顺序是反过来的
    所以必须让一个stack保持当前queue的所有数据，然后每次加入之后，再把数据重新push回一个stack
     */
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Two_Stack_Queue_232(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    // 将数据从stack1里push到stack2，pop，然后再push回stack
    public int pop() {
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int value = stack2.pop();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return value;
    }

    public int peek() {
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int value = stack2.peek();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return value;
    }

    public boolean empty() {
        return stack1.isEmpty();
    }
}
