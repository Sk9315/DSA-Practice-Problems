/*
Merge K sorted linked lists
Difficulty: MediumAccuracy: 57.01%Submissions: 125K+Points: 4Average Time: 60m
Given an array arr[] of n sorted linked lists of different sizes. Your task is to merge all these lists into a single sorted linked list and return the head of the merged list.

Examples:

Input:
   
Output: 1 -> 2 -> 3 -> 4 -> 7 -> 8 -> 9
Explanation: The arr[] has 3 sorted linked list of size 3, 3, 1.
1st list: 1 -> 3 -> 7
2nd list: 2 -> 4 -> 8
3rd list: 9
The merged list will be: 
    
Input:
   
Output: 1 -> 3 -> 4 -> 5 -> 6 -> 8
Explanation: The arr[] has 3 sorted linked list of size 2, 1, 3.
1st list: 1 -> 3
2nd list: 8
3rd list: 4 -> 5 -> 6
The merged list will be: 
    
Constraints
1 ≤ total no. of nodes ≤ 105
1 ≤ node->data ≤ 103

Expected Complexities
Company Tags
VMWareAmazonMicrosoftOracleNPCI
*/
import java.util.*;
/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    Node mergeKLists(Node[] arr) {
        int size=arr.length;
        for(int i=1;i<size;i+=1){
           Node x= merge(arr[0],arr[i]);
           arr[0]=x;
        }
        return arr[0];
        
    }
    
    public Node merge(Node head1, Node head2){
        Node head=new Node(0);
        Node temp=head;
        while(head1!=null && head2!=null){
            if(head1.data<head2.data){
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