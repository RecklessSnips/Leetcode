package Noobie.LinkedList;

public class RemoveElements_203 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 用两个变量
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        // 代表上一层刚到的 node，用来处理整个链表的链接
        ListNode current = head;
        // 用来循环整个链表
        ListNode tmp = head;
        // 处理返回 head 需要被移除（所有node都一样）
        while(head != null && head.val == val){
            head = head.next;
        }
        // 到这里head要么是一个unique，要么是null
        while (tmp != null){
            // 因为tmp本身从head开始，而不是next的元素开始
            if (tmp.val == val){
                //将当前current的下一个变成tmp的下一个，直到没有重复的
                current.next = tmp.next;
                // 切换tmp
                tmp = tmp.next;
            }else{
                // 将 刚刚看过的tmp存到current里
                current = tmp;
                // tmp 后移
                tmp = tmp.next;
            }
        }
        return head;
    }
}
