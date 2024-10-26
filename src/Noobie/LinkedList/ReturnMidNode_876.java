package Noobie.LinkedList;

public class ReturnMidNode_876 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode middleNode(ListNode head) {
        // 快慢指针，当快指针遍历完成之后，说明慢指针刚好到一半
        ListNode slow = head;
        ListNode faster = head;
        while (faster != null && faster.next != null){
            slow = slow.next;
            faster = faster.next.next;
        }
        return slow;
    }
}
