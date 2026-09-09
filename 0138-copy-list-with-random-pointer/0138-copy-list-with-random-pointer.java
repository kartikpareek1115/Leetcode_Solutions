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

        //Brute-Force
        // Node temp = head;
        // ArrayList<Node> copy = new ArrayList<>();

        // while(temp != null){
        //     copy.add(new Node(temp.val));
        //     temp = temp.next;
        // }

        // temp = head;
        // int i = 0;

        // while (temp != null){
            
        //     if(temp.next != null){
        //         copy.get(i).next = copy.get(i+1);
        //     }

        //     if(temp.random != null){
        //         Node randomTemp = head;
        //         int j = 0;
        //         while(randomTemp != temp.random){
        //             randomTemp = randomTemp.next;
        //             j++;
        //         }
        //         copy.get(i).random = copy.get(j); 
        //     }
        //     temp = temp.next;
        //     i++;
           
        // }
        // return copy.get(0);


       //Optimal
       insertCopyInBetween(head);
       connectRandomPointers (head);
       return retreiveList(head);
    
    }
    void insertCopyInBetween(Node head){
        Node temp = head;
        while(temp != null){
            Node nextElement = temp.next;
            Node copy = new Node(temp.val);
            copy.next = nextElement;
            temp.next = copy;
            temp = nextElement;
        }
    }

    void connectRandomPointers (Node head){
        Node temp = head;
        while(temp != null){
            Node copyNode = temp.next;
            if(temp.random != null){
                copyNode.random = temp.random.next;
            }
            else{
                copyNode.random =  null;
            }
            temp = temp.next.next;
        }
    }

    Node retreiveList(Node head){
        Node dummy = new Node(-1);
        Node temp = head;
        Node res = dummy;
        while (temp != null){
           res.next = temp.next;
           res = res.next;

           temp.next = temp.next.next;
           temp = temp.next;
        }
        return dummy.next;
    }
}