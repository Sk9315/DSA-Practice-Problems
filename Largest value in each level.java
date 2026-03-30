/*Given a binary tree, find the largest value in each level.

Example 1:

Input :
        1
       / \
      2   3 

Output : 1 3
Explanation : 
There are two levels in the tree :
1. {1}, max = 1
2. {2, 3}, max = 3
Example 2:

Input :
        4
       / \
      9   2
     / \   \
    3   5   7 

Output : 4 9 7
Explanation : 
There are three levels in the tree:
1. {4}, max = 4
2. {9, 2}, max = 9
3. {3, 5, 7}, max=7
Your task :
You don't need to read input or print anything. Your task is to complete the function largestValues() which takes the root node of the tree as input and returns a vector containing the largest value in each level. 
 
Expected Time Complexity : O(n) , where n = number of nodes
Expected Auxiliary Space : O(n) , where n = number of nodes
 
Constraints : 
1 ≤ Number of nodes ≤ 10^5
Company Tags
Amazon
Topic Tags

*/
import java.util.*;
class Solution {
    public ArrayList<Integer> largestValues(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Deque<Node> dq1 = new ArrayDeque<>();
        Deque<Node> dq2 = new ArrayDeque<>();
        dq1.offer(root);
        
        while(!dq1.isEmpty() || !dq2.isEmpty()){
            
            if(!dq1.isEmpty()){
                int maxVal = Integer.MIN_VALUE;
                while(!dq1.isEmpty()){
                    Node node = dq1.poll(); // safe removal
                    maxVal = Math.max(maxVal, node.data);
                    if(node.left != null) dq2.offer(node.left);
                    if(node.right != null) dq2.offer(node.right);
                }
                ans.add(maxVal);
            }
            
            if(!dq2.isEmpty()){
                int maxVal = Integer.MIN_VALUE;
                while(!dq2.isEmpty()){
                    Node node = dq2.poll(); // use dq2
                    maxVal = Math.max(maxVal, node.data);
                    if(node.left != null) dq1.offer(node.left);
                    if(node.right != null) dq1.offer(node.right);
                }
                ans.add(maxVal);
            }
        }
        return ans;
    }
}