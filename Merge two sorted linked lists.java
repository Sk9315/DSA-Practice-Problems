/*
Given the head of two sorted linked lists consisting of nodes respectively. Merge both lists and return the head of the sorted merged list.

Examples:

Input:
  
Output: 2 -> 3 -> 5 -> 10 -> 15 -> 20 -> 40
Explanation:
   
Input:
  
Output: 1 -> 1 -> 2 -> 4
Explanation:
  
Constraints:
1 ≤ list1.size, list2.size ≤ 103
0 ≤ node->data ≤ 105

Expected Complexities
Company Tags
ZohoFlipkartAccoliteAmazonMicrosoftSamsungFactSetMakeMyTripOracleBrocadeSynopsysOATS SystemsBelzabarNPCI
*/
import java.util.*;
/*
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    Node sortedMerge(Node head1, Node head2) {
        // code here
        Node head=new Node(0);
        Node temp=head;
        Node temp1=head1;
        Node temp2=head2;
        while(temp1!= null && temp2!=null){
            if(temp1.data>temp2.data){
                temp.next=temp2;
                head2=head2.next;
                temp2.next=null;
                temp2=head2;
            }
            else{
                temp.next=temp1;
                head1=head1.next;
                temp1.next=null;
                temp1=head1;
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