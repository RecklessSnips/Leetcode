package Noobie;

import java.util.Stack;

public class Min_String_Length_2696 {


    /*
    将s中每次取出来一个，跟stack的top比较，如果是AB / CD，那么移除，否则添加, 然后用continue来跳过最后的push
     */
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if (!stack.isEmpty()){
                if ((stack.peek() == 'A' && c == 'B') ||
                        (stack.peek() == 'C' && c == 'D')){
                    stack.pop();
                    continue;
                }else{
                    stack.push(c);
                    continue;
                }
            }
            stack.push(c);
        }
        return stack.size();
    }
}
