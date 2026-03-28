/*
Given the root of a Binary Tree, your task is to return its Postorder Traversal.

Note: A postorder traversal first visits the left child (including its entire subtree), then visits the right child (including its entire subtree), and finally visits the node itself.

Examples:

Input: root = [19, 10, 8, 11, 13]

Output: [11, 13, 10, 8, 19]
Explanation: The postorder traversal of the given binary tree is [11, 13, 10, 8, 19].
Input: root = [11, 15, N, 7]
 
Output: [7, 15, 11]
Explanation: The postorder traversal of the given binary tree is [7, 15, 11].
Constraints:
1 ≤ number of nodes ≤ 3*104
0 ≤ node->data ≤ 105

Expected Complexities
Company Tags
Morgan StanleySnapdealWalmart
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
    public ArrayList<Integer> postOrder(Node root) {
        //  code here
        ArrayList<Integer> lst = new ArrayList<>();
        pTraverse(lst, root);
        return lst;
    }

    public void pTraverse(ArrayList<Integer> lst, Node root) {
        if (root == null) {
            return;
        }

              // Root
        pTraverse(lst, root.left);  // Left
        pTraverse(lst, root.right); // Right
        lst.add(root.data); 
    }
    
}
