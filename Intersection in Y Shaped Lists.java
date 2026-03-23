/*
You are given the heads of two non-empty singly linked lists, head1 and head2, that intersect at a certain point. Return that Node where these two linked lists intersect.

Note: It is guaranteed that the intersected node always exists.

In the custom input you have to give input for CommonList which pointed at the end of both head1 and head2 to form a Y-shaped linked list.
Examples:

Input: head1: 10 -> 15 -> 30, head2: 3 -> 6 -> 9 -> 15 -> 30
Output: 15
Explanation: From the above image, it is clearly seen that the common part is 15 -> 30, whose starting point is 15.
    
Input: head1: 4 -> 1 -> 8 -> 5, head2: 5 -> 6 -> 1 -> 8 -> 5
Output: 1
Explanation: From the above image, it is clearly seen that the common part is 1 -> 8 -> 5, whose starting point is 1.
    
Constraints:
2 ≤ total number of nodes ≤ 2*105
-104 ≤ node->data ≤ 104

Expected Complexities
Company Tags
VMWareFlipkartAccoliteAmazonMicrosoftSnapdealD-E-ShawFactSetMakeMyTripVisaGoldman SachsMAQ SoftwareAdobeQualcomm
Topic Tags


*/
import java.util.*;
/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    public Node intersectPoint(Node head1, Node head2) {
        // code here
        int count1=0;
        int count2=0;
        Node temp1=head1;
        Node temp2=head2;
        while(temp1!=null){
            count1++;
            temp1=temp1.next;
        }
        while(temp2!=null){
            count2++;
            temp2=temp2.next;
        }
        if(count2>count1){
            int diff=count2-count1;
            while(diff>0){
                head1=head1.next;
                diff--;
            }
            return head1;
        }
        else if(count2<count1){
            int diff=count1-count2;
            while(diff>0){
                head2=head2.next;
                diff--;
            }
            return head2;
        }
        else{
            while(head1!=head2){
                head1=head1.next;
                head2=head2.next;
            }
            return head2;
        }
        
    }
}