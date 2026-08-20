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
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        //Brute Force
        // ListNode temp = head;
        // Stack<Integer> s = new Stack<Integer>();
        // while(temp != null){
        //     s.push(temp.val);
        //     temp = temp.next;
        // }
        // temp = head;
        // while(temp != null){
        //     temp.val = s.pop();
        //     temp = temp.next;
        // }
        // return head;

        //optimal
        // ListNode temp = head;
        // ListNode prev = null;
        // while(temp != null){
        //     ListNode front = temp.next;
        //     temp.next = prev;
        //     prev = temp;
        //     temp = front;
        // }
        // return prev;

        //recursive approach
        ListNode  newHead = reverseList(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead; 
    }
}