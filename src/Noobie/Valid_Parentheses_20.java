package Noobie;

import java.util.Stack;

public class Valid_Parentheses_20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            switch (curr){
                case '(':
                case '[':
                case '{':
                    stack.push(curr);
                    break;
                case ')':
                    if(stack.isEmpty() || stack.pop() != '(') return false;
                    break;
                case ']':
                    if(stack.isEmpty() || stack.pop() != '[') return false;
                    break;
                case '}':
                    if(stack.isEmpty() || stack.pop() != '{') return false;
                    break;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        Valid_Parentheses_20 v = new Valid_Parentheses_20();
        String s = "{[]}";
        char c = '{';
        char c1 = '}';
        System.out.println(v.isValid("{[]}"));
        System.out.println(Character.compare(c, c1));
        System.out.println(s.charAt(0));
        System.out.println(s.charAt(s.length()-1));
        System.out.println(Character.compare(s.charAt(0),s.charAt(s.length()-1)));
    }
}
