/*
Given the root of a binary tree, your task is to return its Preorder traversal.

Note: A preorder traversal first visits the node, then visits the left child (including its entire subtree), and finally visits the right child (including its entire subtree).

Examples:

Input: root = [1, 4, N, 4, 2]
   
Output: [1, 4, 4, 2]
Explanation: The preorder traversal of the given binary tree is [1, 4, 4, 2]
Input: root = [6, 3, 2, N, 1, 2, N]
    
Output: [6, 3, 1, 2, 2] 
Explanation: The preorder traversal of the given binary tree is [6, 3, 1, 2, 2] 
Constraints:
1 ≤ number of nodes ≤ 3*104
0 ≤ node->data ≤ 105

Expected Complexities
Company Tags
FlipkartAmazonMicrosoftWalmart
*/
import java.util.*;
/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> preOrder(Node root) {
        //  code here
        ArrayList<Integer> lst = new ArrayList<>();
        pTraverse(lst, root);
        return lst;
    }

    public void pTraverse(ArrayList<Integer> lst, Node root) {
        if (root == null) {
            return;
        }

        lst.add(root.data);          // Root
        pTraverse(lst, root.left);  // Left
        pTraverse(lst, root.right); // Right
    }
    
}