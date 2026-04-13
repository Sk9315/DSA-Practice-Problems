/*
Given the root of a Binary Search Tree and a node value key, find if the node with value key is present in the BST or not.

Examples:

Input: root = [6, 2, 8, N, N, 7, 9], key = 8
    
Output: true
Explanation: 8 is present in the BST as right child of root.
Input: root = [16, 12, 18, 10, N, 17, 19], key = 14
    
Output: false
Explanation: 14 is not present in the BST
Constraints:
1 ≤ number of nodes ≤ 3*104
1 ≤ node->data, key ≤ 109

Expected Complexities
Company Tags
Linkedin
*/
import java.util.*;
/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public boolean search(Node root, int key) {
       
        int ans=find(root,key);
        return 1==ans;
    }
    
    public int find(Node root, int key){
         if(root==null){
            return 0;
        } 
        if(root.data==key){
            return 1;
        }
        if(root.data>key){
          return find(root.left,key);
        }
        else{
            return find(root.right,key);
        }
    }
}