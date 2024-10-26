package Medium;

import java.text.DecimalFormat;

public class Pow_50 {

    public double myPow(double x, int n) {
        DecimalFormat df = new DecimalFormat("0.00000");
        double result = 1;
        if (n == 0 || x == 1){
            return 1;
        }else if (n > 0){
            int i = 0;
            while (i < n){
                result *= x;
                i++;
            }
        }else{
            result = 1/Math.pow(x, Math.abs(n));
        }
        return Double.parseDouble(df.format(result));
    }

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.00000");
        System.out.println(df.format(2.000*2.000*2.000*2.000*2.000));
    }
}
