package Noobie.LinkedList;

public class ReversLinkedlist_206 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
        // 用来连接前一个node
        ListNode prev = null;
        // 用来遍历整个链表
        ListNode current = head;
        // 用来储存current.next
        ListNode tmp = head;
        while (current != null){
            tmp = current.next;
            current.next = prev;
            prev = current;
            current = tmp;
        }
        return prev;
    }
}
