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
     
        Node newHead = new Node(0);
        Node temp2 = newHead;
        
        Node temp1 = head;
        
        HashMap<Node,Node> mp = new HashMap<Node,Node>();
        
        while(temp1 != null){
            Node newNode = new Node(temp1.val);
            temp2.next = newNode;
            mp.put(temp1,newNode);
            temp2 = temp2.next;
            temp1 = temp1.next;
        }
        
        temp1 = head;
        while(temp1 != null){
            (mp.get(temp1)).random = mp.get(temp1.random);
            temp1 = temp1.next;
        }

        return newHead.next;
        
    }
}