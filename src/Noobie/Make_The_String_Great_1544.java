package Noobie;

import java.util.Stack;

public class Make_The_String_Great_1544 {
    /*
    每遇到一个符号。push到stack的顶上，如果当前string跟top相同，全部移除，最后返回stack
    原理简单，处理好uppercase就行
     */
    public static String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if (!stack.isEmpty() && Math.abs(stack.peek() - c) == 32) {
                stack.pop(); // They cancel each other out
            } else {
                stack.push(c); // No cancellation, so add to stack
            }
        }
        return stack.toString().replaceAll("\\[", "").replaceAll("]", "").replaceAll(", ", "");
    }

    public static void main(String[] args) {
        String s = "leEeetcode";
        System.out.println(makeGood(s));
    }
}
