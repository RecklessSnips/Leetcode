package Noobie.array;

public class C1346 {

    public static boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                // 当不是本身时（避免 0 = 2 * 0)
                if (i != j) {
                    if (arr[i] == 2 * arr[j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkIfExist(new int[]{10, 2, 5, 3}));
        System.out.println(checkIfExist(new int[]{3,1,7,11}));
        System.out.println(checkIfExist(new int[]{7,1,14,11}));
        System.out.println(checkIfExist(new int[]{0, -2, 2}));
        System.out.println(checkIfExist(new int[]{0, 0}));
    }
}
