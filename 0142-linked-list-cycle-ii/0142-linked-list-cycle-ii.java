/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        //Brute Force
        // ListNode temp = head;
        // HashMap<ListNode, Integer> map = new HashMap<>();
        // while(temp != null){
        //       if(map.containsKey(temp)){
        //         return temp;
        //       }
        //       map.put(temp,1);
        //       temp = temp.next;
        // }
        // return null;

        //Optimal
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                fast = head;
                while(fast != slow){
                    slow = slow.next;
                    fast = fast.next;
                    
                }
                return slow;
            }

        }
        return null;
    }
}