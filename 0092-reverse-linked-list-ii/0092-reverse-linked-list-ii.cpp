/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    
    ListNode* reverseBetween(ListNode* head, int left, int right) {
        if(left>=right || head==NULL || head->next==NULL){
            return head;
        }
        int count=1;
        
        ListNode *prev=NULL;
        ListNode *curr=head;
        ListNode *nexxt=head->next;
        ListNode *prevLeft=NULL;
        
        while(count<=right && curr!=NULL){
            if(count==left-1){
                prevLeft=curr;
            }
            else if(count>=left+1 && count<=right){
                curr->next=prev;
            }
            prev=curr;
            curr=nexxt;
            if(curr!=NULL){
                 nexxt=curr->next;   
            }
            count++;
        }
        
        if(prevLeft==NULL){
            head->next=curr;
            return prev;
        }
        
        prevLeft->next->next=curr;
        prevLeft->next=prev;
        return head;
    }
};