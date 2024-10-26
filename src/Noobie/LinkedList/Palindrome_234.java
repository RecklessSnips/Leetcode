package Noobie.LinkedList;

import java.util.Stack;

public class Palindrome_234 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        // 需要一个 head node的reference来帮忙遍历，否则head就被动了，不要动head!
        ListNode front = head;
        while (front != null){
            stack.push(front.val);
            front = front.next;
        }
        boolean isPalindrome = true;
        while (!stack.isEmpty()){
            if (stack.peek() == head.val){
                stack.pop();
                head = head.next;
            }else{
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }
}
