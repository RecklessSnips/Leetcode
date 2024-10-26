package Noobie.LinkedList;

public class ConvertBinaryToDecimal_1290 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int getDecimalValue(ListNode head) {
        StringBuilder builder = new StringBuilder();
        ListNode front = head;
        while (front != null){
            builder.append(front.val);
            front = front.next;
        }
        return Integer.parseInt(builder.toString(), 2);
    }
}
