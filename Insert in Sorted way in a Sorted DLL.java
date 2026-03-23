/*
Given a sorted doubly linked list and an element x, you need to insert the element x into the correct position in the sorted Doubly linked list(DLL).

Note: The DLL is sorted in ascending order

Example:

Input: LinkedList: 3->5->8->10->12 , x = 9

Output: 3->5->8->9->10->12

Explanation: Here node 9 is inserted in the Doubly Linked-List.
Input: LinkedList: 1->4->10->11 , x = 15

Output: 1->4->10->11->15

Constraints:
1 <= number of nodes <= 103
1 <= node -> data , x <= 104

Expected Complexities
Time Complexity: O(n)
Auxiliary Space: O(1)
Topic Tags
doubly-linked-listLinked ListData Structures

*/
import java.util.*;
/*class of the node of the DLL is as
/*
class Node {
    int data;
    Node prev, next;
    Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}
*/
class Solution {
    public Node sortedInsert(Node head, int x) {
        // add your code here
        Node back=null;
        Node curr=head;
        boolean flag=false;
        
        if(head.data>=x){
                Node temp=new Node(x);
                head.prev=temp;
                temp.next=head;
                temp.prev=null;
                head=temp;
                return head;
        }
        while(curr!=null){
            if(curr.data>=x){
               flag=true;
               Node temp=new Node(x);
               back.next=temp;
               temp.prev=back;
               temp.next=curr;
               curr.prev=temp;
               break;
               
            }
            back=curr;
            curr=curr.next;
        }
        
        if(!flag){
            if(x>head.data){
            Node temp=new Node(x);
            back.next=temp;
            temp.prev=back;
            temp.next=null;
            }
           
        }
        return head;
        
    }
}