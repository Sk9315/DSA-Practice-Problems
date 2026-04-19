/*
Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree.

 

Example 1:


Input: root = [4,2,6,1,3]
Output: 1
Example 2:


Input: root = [1,0,48,null,null,12,49]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [2, 100].
0 <= Node.val <= 105
*/
import java.util.*;
class Solution {
    Integer prev = null;
    int ans = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        findMin(root);
        return ans;
    }

    public void findMin(TreeNode root) {
        if (root == null) return;

        // left
        findMin(root.left);

        // process current node
        if (prev != null) {
            ans = Math.min(ans, root.val - prev);
        }

        prev = root.val;

        // right
        findMin(root.right);
    }
}