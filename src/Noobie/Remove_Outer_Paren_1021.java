package Noobie;

import java.util.Stack;

public class Remove_Outer_Paren_1021 {

    /*
    让stack代表所有的括号，底部留一个代表最外围括号，将每一个遇到的（ ，如果当前stack不为空，说明此时的（不是最外围
    都无脑往stack里加；如果遇到了 ），判断其是否是内部还是外部，需要先将stack的top取出，如果不是empty，说明这个 ）
    不是外围，那么加到answer里, 依次循环
     */
    public String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '('){
                if (!stack.isEmpty()){
                    answer.append(current);
                }
                // 保持整个stack的完整
                stack.push(current);
            } else if (current == ')') {
                stack.pop();
                if (!stack.isEmpty()){
                    answer.append(current);
                }
            }
        }
        return answer.toString();
    }
}
