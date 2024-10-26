package Noobie.LinkedList;

import java.util.Stack;

public class Insertion_160 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        while (headA != null){
            s1.push(headA);
            headA = headA.next;
        }
        while (headB != null){
            s2.push(headB);
            headB = headB.next;
        }
        ListNode intersect = null;
        while (!s1.isEmpty() && !s2.isEmpty()){
            if (s1.peek() == s2.peek()){
                // 这一步是为了如果两个list完全相同，那么最后一个pop出来的（第一个）就是相交的地方
                intersect = s1.pop();
                s2.pop();
            }else{
                intersect = s1.peek().next;
                break;
            }
        }
        return intersect;
    }
}
