package Noobie;

public class Length_of_Last_Word_58 {

    public int lengthOfLastWord(String s) {
        String[] str = s.split("\\s+");
        int length;
        length = str[str.length - 1].length();
        return length;
    }
}
