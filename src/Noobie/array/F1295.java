package Noobie.array;

public class F1295 {

    public static int findNumbers(int[] nums) {
        // 对于每一个，转换成 string 然后用 length 判断
        int counter = 0;
        for (int i: nums) {
            int length = String.valueOf(i).length();
            if (length % 2 == 0){
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(findNumbers(new int[]{12, 345, 2, 6, 7896}));
        System.out.println(findNumbers(new int[]{555,901,482,1771}));
    }
}
