/*
Hard
Topics
premium lock icon
Companies
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

 

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted linked list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
 

Constraints:

k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.

*/
import java.util.*;
/**
 * Definition for singly-linked list.
 * public class ListListNode {
 *     int val;
 *     ListListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int size=lists.length;
        if(size==0){
            return null;
        }
        for(int i=1;i<size;i+=1){
           ListNode x= merge(lists[0],lists[i]);
           lists[0]=x;
        }
        return lists[0];
        
    }
    
    public ListNode merge(ListNode head1, ListNode head2){
        ListNode head=new ListNode(0);
        ListNode temp=head;
        while(head1!=null && head2!=null){
            if(head1.val<head2.val){
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
                
            }
            else{
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
                
            }
            
        }
        if(head1!=null){
            temp.next=head1;
            
        }
        else{
            temp.next=head2;
            
        }
        return head.next;
    }
}