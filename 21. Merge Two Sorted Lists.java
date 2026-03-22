/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

 

Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]
 

Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.

*/
import java.util.*;
/**
 * Definition for singly-linked list.
 * public class ListListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
           // code here
        ListNode head=new ListNode(0);
        ListNode temp=head;
        ListNode temp1=list1;
        ListNode temp2=list2;
        while(temp1!= null && temp2!=null){
            if(temp1.val>temp2.val){
                temp.next=temp2;
                list2=list2.next;
                temp2.next=null;
                temp2=list2;
            }
            else{
                temp.next=temp1;
                list1=list1.next;
                temp1.next=null;
                temp1=list1;
            }
            temp=temp.next;
            
        }
        if(temp1!=null){
            temp.next=temp1;
        }
        else{
            temp.next=temp2;
        }
        return head.next;
    }
}