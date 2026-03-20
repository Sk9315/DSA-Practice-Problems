/*
You are given the head of a Singly linked list. You have to reverse every k node in the linked list and return the head of the modified list.
Note: If the number of nodes is not a multiple of k then the left-out nodes at the end, should be considered as a group and must be reversed.

Examples:

Input: k = 2,
   

Output: 2 -> 1 -> 4 -> 3 -> 6 -> 5
Explanation: Linked List is reversed in a group of size k = 2.


Input: k = 4,   

Output: 4 -> 3 -> 2 -> 1 -> 6 -> 5
Explanation: Linked List is reversed in a group of size k = 4.


Constraints:
1 ≤ size of linked list ≤ 105
0 ≤ node->data ≤ 106
1 ≤ k ≤ size of linked list 
Expected Complexities
Company Tags
PaytmVMWareAccoliteAmazonMicrosoftSnapdealHikeMakeMyTripWalmartGoldman SachsAdobeSAP Labs



*/
/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/
import java.util.*;

class Solution {
    public Node reverseKGroup(Node head, int k) {
        // code here
        Node temp=head;
        int n=0;
        while(temp!=null){
            temp=temp.next;
            n++;
        }
        
        int count=0;
        temp=head;
        Node prev=null;
        Node curr=head;
        Node futr=head;
        while(temp!--->null()=>){
            
           while(curr!=null && futr!=null){
               if(count%k!=0){
                   futr=futr.next;
                   curr.next=prev;
                   prev=curr;
                   curr=futr;   
                   count++;h
               }
               else{
                   
               }
        }
                
            }
        }
    }
}
            