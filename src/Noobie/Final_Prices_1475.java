package Noobie;

import java.util.Stack;

public class Final_Prices_1475 {
    /*
    用一个stack来储存已经计算过的，不断循环数组，每次循环先push到stack的顶部，开始从剩下的开始跟top比较
    如果找到第一个小的，那么就直接break掉，开始找下一个。（因为不是找整个discount中最小的）最后返回整个stack就像
     */

    public static int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            stack.push(prices[i]);
            // 开始找第一个比当前top小的
            for (int j = i+1; j < prices.length; j++) {
                if (stack.peek() >= prices[j]){
                    int discount = stack.pop();
                    stack.push( discount- prices[j]);
                    // 找到了，开始找下一个数字的discount
                    break;
                }
            }
        }
        // 单纯为了返回，可以用别的方法提高效率
        int[] answer = new int[prices.length];
        for (int i = 0; i < stack.size(); i++) {
            answer[i] = stack.elementAt(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(finalPrices(new int[]{8,4,6,2,3}));
    }
}
