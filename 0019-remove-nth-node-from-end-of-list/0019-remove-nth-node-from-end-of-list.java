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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null ){
            return head;
        }

        //Brute - force
        // ListNode temp = head;
        // int count = 0;
        // while(temp != null){
        //     count++;
        //     temp = temp.next;
        // }
        // if(count == n){
        //     return head.next;
        // }
        // int res = count - n;
        // temp = head;
        // while(res != 0){
        //     res--;
            
        //     if(res == 0){
        //        break;
        //     }
        //     temp = temp.next;
        // }
        //  temp.next = temp.next.next;

        //  return head;


        //Optimal -- fast and slow pointer
        ListNode slow = head;
        ListNode fast = head;
        for(int i = 0; i<n ; i++){
            fast = fast.next;
        }

        if (fast == null) {
    return head.next;
}
         
        while(fast != null && fast.next != null  ){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;

    }
}