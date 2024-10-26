package Noobie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Fizz_Buzz_412 {
    public static List<String> fizzBuzz(int n) {
        String[] s = new String[n];
        for (int i =1; i< s.length+1; i++) {
            if ( i%3 == 0 && i%5 == 0){
                s[i-1] = "FizzBuzz";
            }else if (i%3 == 0){
                s[i-1] = "Fizz";
            }else if (i%5 == 0){
                s[i-1] = "Buzz";
            }
            else {
                s[i-1] = Integer.toString(i);
            }
        }
        return Arrays.asList(s);
    }

    public static void main(String[] args) {
        System.out.println(fizzBuzz(5));
    }
}
