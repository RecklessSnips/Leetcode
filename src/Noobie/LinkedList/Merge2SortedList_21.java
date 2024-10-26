package Noobie.LinkedList;

public class Merge2SortedList_21 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        if (list1 == null){
            head = list2;
            return head;
        }
        if (list2 == null){
            head = list1;
            return head;
        }
        if (list1.val < list2.val){
            head = list1;
            head.next = mergeTwoLists(list1.next, list2);
        }else{
            head = list2;
            head.next = mergeTwoLists(list1, list2.next);
        }
        return head;
    }
}
