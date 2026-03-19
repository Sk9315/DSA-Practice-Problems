import java.util.*;
/*
Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

 

Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false
 

Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9
 

Follow up: Could you do it in O(n) time and O(1) space?


*/
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
         ListNode temp=head;
        int n=0;
        while(temp!=null){
            n++;
            temp=temp.next;
        }
        if(n==1){
            return true;
        }
        if(n==2){
            if(head.val==head.next.val){
                return true;
            }
            else{
                return false;
            }
        }
        if(head==null){
            return false;
        }

        int count=n/2;

        ListNode prev=null;
        ListNode curr=head;
        while(count>0){
            prev=curr;
            curr=curr.next;
            count--;
        }

        //sepeating the list into two parts or breaking the lnk
        prev.next=null;

        //reversing the last half of the linked list;
        ListNode prv=null;
        ListNode front=curr;
        while(curr!=null){
            front=front.next;
            curr.next=prv;
            prv=curr;
            curr=front;
        }

        ListNode head2=prv;
        while(head!=null){
            if(head.val!=head2.val){
                return false;
            }
            head=head.next;
            head2=head2.next;
        }
        return true;
    }
}