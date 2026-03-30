/*
Given a root binary tree and the task is to find the spiral order traversal of the tree and return the list containing the elements.
Spiral Order Traversal mean: Starting from level 0 for root node, for all the even levels we print the node's value from right to left and for all the odd levels we print the node's value from left to right.

Examples:

Input: root = [1, 3, 2]
 
Output: [1, 3, 2]
Explanation: Start with root (1), print level 0 (right to left), then level 1 (left to right).
Input: root = [10, 20, 30, 40, 60]

Output: [10, 20, 30, 60, 40]
Explanation: Start with root (10), print level 0 (right to left), level 1 (left to right), and continue alternating.
Constraints:
1  ≤ number of nodes  ≤105
0  ≤ node->data  ≤ 105

Expected Complexities
Company Tags
FlipkartMorgan StanleyAccoliteAmazonMicrosoftHikeHousing.comMakeMyTripOla CabsPayuTeradataWalmartAdobe
*/
import java.util.*;
/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    public ArrayList<Integer> findSpiral(Node root) {
        // code here
        ArrayList<Integer>al=new ArrayList<>();
        Stack<Node>st1=new Stack<>();//left to right
        Stack<Node>st2=new Stack<>();//right to left
        st2.push(root);
        
        while(!st1.isEmpty()||!st2.isEmpty()){
            if(!st1.isEmpty()){
                while(!st1.isEmpty()){
                     if(st1.peek().left!=null){
                        st2.push(st1.peek().left);
                    }
                    if(st1.peek().right!=null){
                        st2.push(st1.peek().right);
                    }
                   
                    al.add(st1.peek().data);
                    st1.pop();  
                }
            }
            if(!st2.isEmpty()){
                while(!st2.isEmpty()){
                    if(st2.peek().right!=null){
                        st1.push(st2.peek().right);
                    }
                    if(st2.peek().left!=null){
                        st1.push(st2.peek().left);
                    }
                    
                    al.add(st2.peek().data);
                    st2.pop();
                }
            }
            
        }
        
        return al;
        
    }
}