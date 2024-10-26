package Noobie;

import java.util.Stack;

public class Remove_All_Adjacent_1047 {

    /*
    不断无脑push到stack里，如果跟当前top相同，pop，并且不要加入这个新的！
     */
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (!stack.isEmpty()){
                if (stack.peek().equals(current)){
                    stack.pop();
                    continue;
                }
            }
            stack.push(current);
        }
        for(char c: stack){
            answer.append(c);
        }
        return answer.toString();
    }
}
