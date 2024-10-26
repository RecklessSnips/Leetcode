package Noobie;

import java.util.Stack;

public class Baseball_Game_682{

    public static  int calPoints(String[] operations) {
        /*
        维护一个总分数。将每个char依次push到stack里，如果是数字，那么总分加上它，并且添加到stack里，
        如果是c，则从stack里取出，如果是d，则push一个新的，是当前top的double，如果是+，则push前两次
        的分数，需要pop两次，再加回去
        O(n)
         */
        int score = 0;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < operations.length; i++) {
            String current = operations[i];
            switch (current){
                case "C":
                    stack.pop();
                    break;
                case "D":
                    stack.push(Integer.toString(Integer.parseInt(stack.peek()) * 2));
                    break;
                case "+":
                    int a = Integer.parseInt(stack.pop());
                    int b = Integer.parseInt(stack.pop());
                    int c = a + b;
                    stack.push(Integer.toString(b));
                    stack.push(Integer.toString(a));
                    stack.push(Integer.toString(c));

                    break;
                default:
                    stack.push(current);
            }
            System.out.println(stack);
        }
        while (!stack.isEmpty()){
            score += Integer.parseInt(stack.pop());
        }
        return score;
    }


    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }
}
