/*
Given the root of a binary tree, determine if it is height-balanced or not.

Note: A binary tree is considered height-balanced if the absolute difference in heights of the left and right subtrees is at most 1 for every node in the tree.

Examples:

Input: root = [10, 20, 30, 40, 60]
    
Output: true 
Explanation: The height difference between the left and right subtrees at all nodes is at most 1. Hence, the tree is balanced.
Input: root = [1, 2, 3, 4, N, N, N, 5]
   
Output: false
Explanation: The height difference between the left and right subtrees at node 2 is 2, which exceeds 1. Hence, the tree is not balanced.
Constraints:
1 ≤ number of nodes ≤ 1000
1 ≤ node->data ≤ 104

Expected Complexities
Company Tags
AmazonMicrosoftWalmart
*/
import java.util.*;
class Solution {
    public static int valid = 1;

    public boolean isBalanced(Node root) {
        valid = 1;           // reset before use
        height(root);           // important!
        return valid == 1;
    }

    public int height(Node root) {
        if (root == null) {
            return 0;
        }

        int Lh = height(root.left);
        int Rh = height(root.right);

        if (Math.abs(Lh - Rh) > 1) {
            valid = 0;
        }

        return 1 + Math.max(Lh, Rh);
    }
}