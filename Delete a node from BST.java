/*
Given the root of a binary search tree and a node value x. Delete the node with the given value x from the tree. If no node with value x exists, then do not make any change. Return the root of the tree after deleting the node with value x.

Note: You may return any valid BST after deleting the specified node. The driver code will print true if the resulting tree is a valid BST after deletion, and false otherwise.

Examples :

Input: root = [2, 1, 3], x = 12

Output: true
Explanation: In the given input there is no node with value 12, so the tree will remain same.
Input: root = [1, N, 2, N, 8, 5, 11, 4, 7, 9, 12], x = 11

Output: true
Explanation: In the given input, one of the possible tree after deleting 11 will be

Input: root = [2, 1, 3], x = 3

Output: [2, 1]
Explanation: In the given input, only possible tree after deleting 3 will be

Constraints:
1 ≤ number of nodes ≤ 105
1 ≤ node->data, x ≤ 105

Expected Complexities
Company Tags
AccoliteAmazonSamsungAdobeQualcomm

*/
import java.util.*;
/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public Node del(Node temp){
        //deleting a leaf node
        if(temp.left==null && temp.right==null){
            temp=null;
            return null;
        }
        else if(temp.left==null){
            Node x=temp.right;
            temp=null;
            return x;
        }
        else if(temp.right==null){
            Node x=temp.left;
            temp=null;
            return x;
        }
        
        else if(temp.left!=null&& temp.right!=null){
            Node maxVal=null;
            Node parent=temp;
            Node child=temp.left;
            while(child.right!=null){
                parent=child;
                child=child.right;
            }
            if(temp!=parent){
               parent.right=child.left;
               child.left=temp.left;
               child.right=temp.right;
               temp=null;
               return child;
            }
            else{
                child.right=temp.right;
                temp=null;
                return child;
            }
           
        }
        return null;
        
    }
    public Node delNode(Node root, int x) {
        if(root==null){
            return null;
        }
        if(root.data==x){
         return  del(root);
            //deletion logic
        }
        if(root.data>x){
          root.left= delNode(root.left,x);
          return root;
        }
        else{
           root.right= delNode(root.right,x);
           return root;
        }
        
    }
    
}