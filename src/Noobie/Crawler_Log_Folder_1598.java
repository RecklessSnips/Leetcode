package Noobie;

import java.util.Objects;
import java.util.Stack;

public class Crawler_Log_Folder_1598 {

    public static int minOperations(String[] logs) {
        /*
        iterate数组，将每一个操作push到stack顶部，或者不push，或者将原有的pop出来。栈顶代表当前的目录层级
         */
        Stack<String> stack = new Stack<>();
        for (String log : logs) {
            switch (log){
                case "./":
                    break;
                case "../":
                    if (!stack.isEmpty()){
                        stack.pop();
                    }
                    break;
                default:
                    stack.push(log);
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        String[] s = new String[]{"./","../","./"};
        System.out.println(minOperations(s));
    }
}
