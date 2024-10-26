package Noobie;

public class Remove_All_Value_203 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val){
            head = head.next;
        }
        ListNode node = head;
        while (node != null && node.next != null){
            if (node.next.val == val){
                node.next = node.next.next;
            }else{
                node = node.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
