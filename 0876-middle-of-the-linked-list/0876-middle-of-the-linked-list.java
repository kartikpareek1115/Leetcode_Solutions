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
    public ListNode middleNode(ListNode head) {

        // Brute - force solution
        // ListNode temp = head;
        // int count = 0;
        // while(temp != null){
        //     count++;
        //     temp = temp.next;
        // }
        // int mid = (count/2) + 1;
        //  temp = head;
        // while(temp != null){
        //      mid = mid - 1;
        //     if(mid == 0){
        //         break;
        //     }
        //     temp = temp.next;
        // }
        // return temp;

        // Tortoise & Hare 
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}