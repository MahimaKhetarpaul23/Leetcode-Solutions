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
    public ListNode partition(ListNode head, int x) {
        
        ListNode temp = head;
        
        ListNode less = new ListNode(0);
        ListNode greater = new ListNode(0);
        
        ListNode lessStart = less;
        ListNode greaterStart = greater;
        
        while(temp!=null){
            ListNode next = temp.next;
            if(temp.val < x){
                less.next = temp;
                less = less.next;
                less.next = null;
            }
            else{
                greater.next = temp;
                greater = greater.next;
                greater.next = null;
            }
            temp = next; // move temp forward!!
        }
        
        // means no node has less value.
        if(lessStart == less){
            return greaterStart.next;
        }
        
        // means no node has greater value.
        if(greaterStart == greater){
            return lessStart.next;
        }
        
        lessStart = lessStart.next;
        less.next = greaterStart.next;
        return lessStart;
        
    }
}