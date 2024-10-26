package Others;

import java.util.Stack;

public class StackSort {
//    sort a stack only using 1 additional stack and 1 tmp var
    public static Stack<Integer> stackSort(Stack<Integer> stack1){
        Stack<Integer> stack2 = new Stack<>();
//        use tmp to compare then push to the stack2
        int tmp, counter = 0;
        while (!stack1.isEmpty()){
            tmp = stack1.pop();
            while (!stack2.isEmpty()){
                if (stack2.peek() > tmp){
                    stack1.push(stack2.pop());
//                    stack2.push(tmp);
                    counter ++;
                }else{
                    break;
                }
            }
            stack2.push(tmp);
        }
        System.out.println(counter);
        return stack2;
    }


    public static void main(String[] args) {
        /*
        12             12
        3              7
        7              6
        5              5
        6              3
        1    tmp       1

        12

        out: 1, 3, 5, 6, 7, 12
         */
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(6);
        s.push(5);
        s.push(7);
        s.push(3);
        s.push(12);
        System.out.println(s);
        System.out.println(stackSort(s));
    }
}
