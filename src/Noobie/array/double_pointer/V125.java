package Noobie.array.double_pointer;

public class V125 {

    public static boolean isPalindrome(String s) {
        String lowerCase = s.toLowerCase();
        int left = 0;
        int right = lowerCase.length() - 1;
        while (left < right){
            char l = lowerCase.charAt(left);
            char r = lowerCase.charAt(right);
            if (!Character.isLetterOrDigit(l)){
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(r)){
                right--;
                continue;
            }
            if (l == r){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        String s = "race a car";
        System.out.println(s.charAt(6));
    }
}
