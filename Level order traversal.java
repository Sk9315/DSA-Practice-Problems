/*
Given the root of a Binary Tree, your task is to return its Level Order Traversal.

Note: A level order traversal is a breadth-first search (BFS) of the tree. It visits nodes level by level, starting from the root, and processes all nodes from left to right within each level before moving to the next.

Examples:

Input: root = [1, 2, 3]

Output: [[1], [2, 3]]
Explanation: We start with the root node 1, so the first level of the traversal is [1]. Then we move to its children 2 and 3, which form the next level, giving the final output [[1], [2, 3]].
Input: root = [10, 20, 30, 40, 50]

Output: [[10], [20, 30], [40, 50]]
Explanation: We begin with the root node 10, which forms the first level as [10]. Its children 20 and 30 make up the second level, and their children 40 and 50 form the third level, resulting in [[10], [20, 30], [40, 50]].
Constraints:
1 ≤ number of nodes ≤ 3*104
0 ≤ node->data ≤ 109

Expected Complexities
Company Tags
FlipkartMorgan StanleyAccoliteAmazonMicrosoftSamsungD-E-ShawOla CabsPayuAdobeCiscoQualcomm

*/
import java.util.*;
/*
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        // code here
         ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Deque<Node> dq1 = new ArrayDeque<>();
        Deque<Node> dq2 = new ArrayDeque<>();
        dq1.offer(root);
        
        while(!dq1.isEmpty() || !dq2.isEmpty()){
            
            if(!dq1.isEmpty()){
              ArrayList<Integer> temp = new ArrayList<>();
                while(!dq1.isEmpty()){
                    Node node = dq1.poll(); // safe removal
                    temp.add(node.data);
                    if(node.left != null) dq2.offer(node.left);
                    if(node.right != null) dq2.offer(node.right);
                }
                ans.add(temp);
            }
            
            if(!dq2.isEmpty()){
                ArrayList<Integer> temp = new ArrayList<>();
                while(!dq2.isEmpty()){
                    Node node = dq2.poll(); // use dq2
                    temp.add(node.data);
                    if(node.left != null) dq1.offer(node.left);
                    if(node.right != null) dq1.offer(node.right);
                }
                ans.add(temp);
            }
        }
        return ans;
  
    }
}