package Medium;

import java.util.ArrayList;
import java.util.List;

public class Longest_Substring_3 {

    public static int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        List<Character> list = new ArrayList<>();
        int len = 1;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] == arr[i + 1]) {
                break;
            }else {
                list.add(arr[i]);
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(i) != arr[i]){
                        len++;
                    }
                }
            }
        }
        return len;
    }

    public static void main(String[] args) {
//        String a = new String("Hello World");
//        System.out.println(a.substring(1));
//        System.out.println(a.substring(5));
//        System.out.println(a.substring(6));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
