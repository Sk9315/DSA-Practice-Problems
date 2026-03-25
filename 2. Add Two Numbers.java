/*
Medium
Topics
premium lock icon
Companies
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
*/
import java.util.*;
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1=l1;
        ListNode temp2=l2;
        ListNode head=new ListNode(0);
        ListNode temp=head;
        int carry=0;
        while(temp1!=null && temp2!=null){
            int sum=temp1.val+temp2.val;
            
            sum+=carry;
            if(sum>9){ 
                carry=sum/10;
                sum=sum%10;
                ListNode x=new ListNode(sum);
                temp.next=x;
                temp=temp.next;
                

            }
            else{
                ListNode x=new ListNode(sum);
                temp.next=x;
                temp=temp.next;
                carry=0;

            }
            temp1=temp1.next;
            temp2=temp2.next;
           
        }

        if(temp1!=null){
            while(temp1!=null){
                int sum=temp1.val+carry;
               if(sum>9){ 
                carry=sum/10;
                sum=sum%10;
                ListNode x=new ListNode(sum);
                temp.next=x;
                temp=temp.next;
                

            }
            else{
                ListNode x=new ListNode(sum);
                temp.next=x;
                temp=temp.next;
                carry=0;

            }
            temp1=temp1.next;
            }

        }
        else{
            while(temp2!=null){
                int sum=temp2.val+carry;
               if(sum>9){ 
                carry=sum/10;
                sum=sum%10;
                ListNode x=new ListNode(sum);
                temp.next=x;
                temp=temp.next;
                

            }
            else{
                ListNode x=new ListNode(sum);
                temp.next=x;
                temp=temp.next;
                carry=0;

            }
            temp2=temp2.next;
            }

        }
        if(carry!=0){
            ListNode x=new ListNode(carry);
            temp.next=x;
            

        }

        return head.next;
    }
}