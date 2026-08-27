/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
     ListNode collisionPoint(ListNode t1,ListNode t2, int d){
            while(d>0){
                d--;
                t2 = t2.next;
            }
            while(t1 != t2){
                t1 = t1.next;
                t2 = t2.next;
            }
            return t1;
        }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        //Brute Force
        // HashMap<ListNode, Integer> map = new HashMap<>();
        // ListNode  temp = headA;
        // while(temp != null){
        //     map.put(temp, 1);
        //     temp = temp.next;
        // } 
        // temp = headB;
        // while(temp != null){
        //    if( map.containsKey(temp)) {
        //     return temp;
        //    }
        //    temp = temp.next;
        // }
        // return null;

        //Optmial _ 1
        // ListNode temp1 = headA, temp2 = headB;
        // int n1 = 0, n2  = 0;
        // while(temp1 != null){
        //     n1++;
        //     temp1 = temp1.next;
        // }
        // while(temp2 != null){
        //     n2++;
        //     temp2 = temp2.next;
        // }

        // if(n1<n2){
        //     return collisionPoint(headA, headB, n2-n1);
        // }
        // else return collisionPoint(headB, headA, n1-n2);

        //Optimal_2
        ListNode temp1 = headA, temp2 = headB;
        while(temp1 != temp2){
             if (temp1 == null) {
        temp1 = headB;
    } else {
        temp1 = temp1.next;
    }

    if (temp2 == null) {
        temp2 = headA;
    } else {
        temp2 = temp2.next;
    }
        }
        return temp1;
    }


    

}