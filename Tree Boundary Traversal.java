/*
Given a root of a Binary Tree, return its boundary traversal in the following order:

Left Boundary: Nodes from the root to the leftmost non-leaf node, preferring the left child over the right and excluding leaves.

Leaf Nodes: All leaf nodes from left to right, covering every leaf in the tree.

Reverse Right Boundary: Nodes from the root to the rightmost non-leaf node, preferring the right child over the left, excluding leaves, and added in reverse order.

Note: The root is included once, leaves are added separately to avoid repetition, and the right boundary follows traversal preference not the path from the rightmost leaf.

Examples:

Input: root = [1, 2, 3, 4, 5, 6, 7, N, N, 8, 9, N, N, N, N]
Output: [1, 2, 4, 8, 9, 6, 7, 3]
Explanation:

Input: root = [1, N, 2, N, 3, N, 4, N, N] 
Output: [1, 4, 3, 2]
Explanation:

Left boundary: [1] (as there is no left subtree)
Leaf nodes: [4]
Right boundary: [3, 2] (in reverse order)
Final traversal: [1, 4, 3, 2]
Constraints:
1 ≤ number of nodes ≤ 105
1 ≤ node->data ≤ 105

Expected Complexities
Company Tags
FlipkartMorgan StanleyAccoliteAmazonMicrosoftOYO RoomsSamsungSnapdealFactSetHikePayuKritikal Solutions
*/
import java.util.*;
/*
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    public void leftSub(Node root,ArrayList<Integer>ans){
        if(root==null||(root.left==null && root.right==null)){
            return;
        }
        ans.add(root.data);
        if(root.left!=null){
            leftSub(root.left,ans);
        }
        else{
            leftSub(root.right,ans);
        }
        
    }
    
    public void leaf(Node root,ArrayList<Integer>ans){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            ans.add(root.data);
            return;
        }
        leaf(root.left,ans);
        leaf(root.right,ans);
        
    }
    
    public void rightSub(Node root,ArrayList<Integer>ans){
        if(root==null||(root.left==null && root.right==null)){
            return;
        }
         if(root.right!=null){
            rightSub(root.right,ans);
        }
        else{
            rightSub(root.left,ans);
        }
        ans.add(root.data);
    }
    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        ArrayList<Integer>ans=new ArrayList<>();
        ans.add(root.data);
        //adding data of the left sub tree except leaf
        leftSub(root.left,ans);
        
        //adding data of the leaf nodes
        if(root.left!=null || root.right!=null){
            leaf(root,ans);
        }
        
        //adding data of the right sub treee in reverse order
        rightSub(root.right,ans);
        
        return ans;
    }
}