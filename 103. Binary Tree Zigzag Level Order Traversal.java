/*
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100
*/
import java.util.*;
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        Deque<TreeNode> st1 = new ArrayDeque<>();
        Deque<TreeNode> st2 = new ArrayDeque<>();

        if (root == null) {
            return ans;
        }

        st1.push(root);

        while (!st1.isEmpty() || !st2.isEmpty()) {

            if (!st1.isEmpty()) {
                ArrayList<Integer> temp = new ArrayList<>();
                while (!st1.isEmpty()) {
                    TreeNode node = st1.pop();
                    temp.add(node.val);

                    
                    if (node.left != null) st2.push(node.left);
                    if (node.right != null) st2.push(node.right);
                }
                ans.add(temp);
            }

            if (!st2.isEmpty()) {
                ArrayList<Integer> temp = new ArrayList<>();
                while (!st2.isEmpty()) {
                    TreeNode node = st2.pop();
                    temp.add(node.val);

                    if (node.right != null) st1.push(node.right);
                    if (node.left != null) st1.push(node.left);
                }
                ans.add(temp);
            }
        }

        return ans;
    }
}