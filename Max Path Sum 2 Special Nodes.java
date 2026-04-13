/*
Given a binary tree in which each node element contains a number. Find the maximum possible path sum from one special node to another special node.

Note: Here special node is a node that is connected to exactly one different node.

Examples:

Input: root = [3, 4, 5, -10, 4, N, N]
                         
Output: 16
Explanation: Maximum Sum lies between special node 4 and 5. 4 + 4 + 3 + 5 = 16.
Input: root = [-15, 5, 6, -8, 1, 3, 9, 2, -3, 0, 4, -1, 10]


Output:  27
Explanation: The maximum possible sum from one special node to another is (3 + 6 + 9 + 0 + -1 + 10 = 27)
Input: root = [3, 4, 1, -10, 4] 

                         
Output: 12
Explanation: Maximum Sum lies between special node 4 and 5. 4 + 4 + 3 + 1 = 12.
Constraints:
2  ≤  number of nodes  ≤  104
-103  ≤ node->data ≤ 103

Expected Complexities
Company Tags
AccoliteAmazonMicrosoftOYO RoomsFactSetDirectiFacebook
*/
import java.util.*;
/* class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */
class Solution {
    int ans=Integer.MIN_VALUE;
    int maxPathSum(Node root) {
        // code here
         int xx=findMin(root);
       if(root.left!=null&&root.right!=null){
       return ans;
       }
       return Math.max(ans,xx);
       
        
    }
    public int findMin(Node root){
        if(root==null){
            return 0;
        }
        if(root.left==null&& root.right==null){
            return root.data;
        }
        
        int lft=findMin(root.left);
        int ryt=findMin(root.right);
        
        //if both left and right exist
        if(root.left!=null && root.right!=null){
            ans=Math.max(ans,root.data+lft+ryt);
            return root.data+Math.max(lft,ryt);
        }
        
        //if only right exist
        if(root.right!=null){
            return root.data+ryt;
        }
        //if only left exist
        if(root.left!=null){
            return root.data+lft;
        }
        return 0;
        
    }
}