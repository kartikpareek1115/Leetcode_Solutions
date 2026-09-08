/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Node temp = head;
        ArrayList<Node> copy = new ArrayList<>();

        while(temp != null){
            copy.add(new Node(temp.val));
            temp = temp.next;
        }

        temp = head;
        int i = 0;

        while (temp != null){
            
            if(temp.next != null){
                copy.get(i).next = copy.get(i+1);
            }

            if(temp.random != null){
                Node randomTemp = head;
                int j = 0;
                while(randomTemp != temp.random){
                    randomTemp = randomTemp.next;
                    j++;
                }
                copy.get(i).random = copy.get(j); 
            }
            temp = temp.next;
            i++;
           
        }
        return copy.get(0);
    }
}