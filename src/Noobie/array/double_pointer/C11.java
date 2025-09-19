package Noobie.array.double_pointer;

public class C11 {

    public static int maxArea(int[] height) {
        /**
         * 1. 启动左右两个指针
         * 2. 以两个指针中高度低的那个为基准，计算面积
         * 3. 然后移动高度低的那个指针， 同时维护当前最大面积, 如果一样，跳出循环
         * 4. 直到 left > right, 返回最大面积
         */
        // 1
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        // 2
        while ( left < right ){
            int length = (right + 1) - (left + 1);
            int lh = height[left];
            int rh = height[right];
            int hei = Math.min(lh, rh);
            int area = length * hei;
            // Compare
            maxArea = Math.max(area, maxArea);

            if (lh < rh){
                left ++;
            } else if (lh > rh) {
                right --;
            } else {
                break;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        // height = [1,8,6,2,5,4,8,3,7]
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
