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
      public ListNode reverse(ListNode head) {
        // Check if the list is empty or has only one node
        if (head == null || head.next == null) {
            return head;  // No change is needed; return the current head
        }

        // Recursive step: Reverse the remaining part of the list and get the new head
        ListNode NewHead = reverse(head.next);

        // Store the next node in 'front' to reverse the link
        ListNode front = head.next;

        // Update the 'next' pointer of 'front' to point to the current head
        front.next = head;

        // Set the 'next' pointer of the current head to null to break the original link
        head.next = null;

        // Return the new head obtained from the recursion
        return NewHead;
    }
    public boolean isPalindrome(ListNode head) {
        // ArrayList<Integer> arr = new ArrayList<>();
        // ListNode temp = head;
        // int i = 0;
        // int count = 0;
        // while(temp != null){
        //     arr.add(temp.val);
        //     i++;
        //     temp = temp.next;
        //    count++;
        // }
        // temp = head;
        // i = count-1;
        // while(temp != null){
        //     if(arr.get(i) != temp.val){
        //         return false;
        //     }
        //     temp = temp.next;
        //     i--;
        // }
        // return true;

        //Optimal
        if(head == null || head.next == null) return true;
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode NewHead = reverse(slow.next);
        ListNode first = head , second = NewHead;
        while(second != null){
            if(first.val != second.val){
                reverse(NewHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverse(NewHead);
        return true;
    }
}