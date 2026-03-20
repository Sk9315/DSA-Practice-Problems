/*
You are given a Doubly Linked List and an integer x. Remove the node at position x (positions are 1-indexed) from the list, and return the head of the updated list.

Examples:

Input: x = 3,
   
Output: 1 <-> 3
Explanation: After deleting the node at position 3 (position starts from 1), the updated linked list is 1 <-> 3.
   
Input: x = 1,
   
Output: 5 <-> 2 <-> 9
Explanation: After deleting the node at position 1, the updated linked list is 5 <-> 2 <-> 9.
   
Constraints:
1 ≤ x ≤ size of the linked list ≤ 106
0 ≤ node->data ≤ 104

Expected Complexities
Company Tags
AmazonWalmart


*/

/*
Structure of a Doubly LinkList
class Node {
    int data;
    Node next;
    Node prev;

    Node(int val) {
        data = val;
        next = null;
        prev = null;
    }
}
*/
import java.util.*;
class Solution {
    public Node delPos(Node head, int x) {
         //handling the edge cases
        
        if(x==1){
            Node tep=head;
            head=tep.next;
            tep.next=null;
            head.prev=null;
            
            return head;
        }
  
       
        Node temp=head;
        Node back=null;
        while(x>1){
            back=temp;
            temp=temp.next;
            x--;
        }
        if(temp.next!=null){
            back.next=temp.next;
            temp.next.prev=back;
            temp.next=null;
            temp.prev=null;
            
        }
        else{
            back.next=null;
            
        }
        
        
        
        return head;
        
        //removing at the middle
        
        
        
                
        //removing at the end
    }
}