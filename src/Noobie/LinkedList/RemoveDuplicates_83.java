package Noobie.LinkedList;

public class RemoveDuplicates_83 {

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

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        // 1, 1, 2, 3, 3
        if(head ==null) return null;
        ListNode listNode = head;
        while (listNode.next != null){
            if (listNode.val == listNode.next.val){
                listNode.next = listNode.next.next;
            }else{
                listNode = listNode.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println(n1.val);
        while (n1.next != null){
            System.out.println(n1.next.val);
            n1 = n1.next;
        }
        System.out.println("Remove duplicates");
        ListNode n = deleteDuplicates(n1);
        System.out.println(n.val);
        while (n.next != null){
            System.out.println(n.next.val);
            n = n.next;
        }
    }
}
