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
    public ListNode deleteMiddle(ListNode head) {
        //Brute Force
        // if(head.next == null){
        //     return null;
        // }
        // ListNode temp = head;
        // int count = 0;
        // while(temp != null){
        //     count++;
        //     temp = temp.next;
        // }
        // temp = head;
        // int res = count/2;
        // while(temp != null){
        //     res--;
        //     if(res == 0){
        //         temp.next = temp.next.next;
        //         break;
        //     }
        //     temp = temp.next;
        // }
        // return head;

        //optimal - hare and tortoise
        if(head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}