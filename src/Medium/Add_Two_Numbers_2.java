package Medium;

import java.util.ArrayList;

public class Add_Two_Numbers_2 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }


      public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
          int carry = 0, sum = 0;
          ListNode head = null;

          while (l1 != null || l2 != null){
              sum = l1.val + l2.val + carry;
              carry = sum/10;
              l1 = l1.next;
              l2 = l2.next;
          }
         return new ListNode(sum);
      }


    }

    public static void main(String[] args) {
        ListNode node0 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);


        System.out.println(2/10);
        System.out.println(12/10);
    }
}
