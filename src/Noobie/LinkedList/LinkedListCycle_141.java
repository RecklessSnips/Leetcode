package Noobie.LinkedList;

public class LinkedListCycle_141 {

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode p1 = head;
        ListNode p2 = head;
        boolean isLoop = false;
        while (p2.next != null && p2.next.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1.val == p2.val){
                isLoop = true;
                break;
            }
        }
        return isLoop;
    }
}
