package Noobie;

import java.util.Stack;

public class Backspace_String_Compare_844 {

    public static boolean backspaceCompare(String s, String t) {
        /*
        将每一个string的字符push到stack的顶部，如果遇到#就pop一个，最后开始判断。
        如果最后的两个stack size不一样，直接false，否则的话一个个pop出来分别比较
         */
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (!stackS.isEmpty() && current == '#'){
                stackS.pop();
            }else if (current != '#'){
                stackS.push(current);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char current = t.charAt(i);
            if (!stackT.isEmpty() && current == '#'){
                stackT.pop();
            }else if (current != '#'){
                stackT.push(current);
            }
        }

        if (stackS.size() != stackT.size()){
            return false;
        }
        while (!stackS.isEmpty() && !stackT.isEmpty()){
            if (stackS.pop() != stackT.pop()){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(backspaceCompare("bxj##tw", "bxj###tw"));
        System.out.println(backspaceCompare("y#fo##f", "y#f#o##f"));
    }
}
