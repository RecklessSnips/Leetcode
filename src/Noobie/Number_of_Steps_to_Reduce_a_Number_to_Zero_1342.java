package Noobie;

public class Number_of_Steps_to_Reduce_a_Number_to_Zero_1342 {

    public static int numberOfSteps(int num) {
        int counter = 0;
        if (num == 0){
            return 0;
        }
        while(num >= 1){
            if (num % 2 != 0) {
                num = num - 1;
                counter++;
            }
            num = num/2;
            counter++;
        }
        return counter - 1;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSteps(14));
    }
}
