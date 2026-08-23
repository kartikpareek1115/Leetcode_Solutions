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
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        int i = 0;
        int count = 0;
        while(temp != null){
            arr.add(temp.val);
            i++;
            temp = temp.next;
           count++;
        }
        temp = head;
        i = count-1;
        while(temp != null){
            if(arr.get(i) != temp.val){
                return false;
            }
            temp = temp.next;
            i--;
        }
        return true;
    }
}