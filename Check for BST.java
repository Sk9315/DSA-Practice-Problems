/*
Difficulty: MediumAccuracy: 25.37%Submissions: 604K+Points: 4Average Time: 30m
Given the root of a binary tree. Check whether it is a BST or not.

A BST is defined as follows:

The left subtree of a node contains only nodes with data less than the node's data.
The right subtree of a node contains only nodes with data greater than the node's data.
Both the left and right subtrees must also be binary search trees.
Note: We are considering that BSTs can not contain duplicate Nodes.

Examples:

Input: root = [2, 1, 3, N, N, N, 5]


Output: true 
Explanation: The left subtree of every node contains smaller data and right subtree of every node contains greater data. Hence, the tree is a BST.
Input: root = [2, N, 7, N, 6, N, 9] 



Output: false 
Explanation: Since the node to the right of node with data 7 has lesser value 6, hence it is not a valid BST.
Input: root = [10, 5, 20, N, N, 9, 25]


Output: false
Explanation: The node with data 9 present in the right subtree has lesser key value than root node 10.
Constraints:
1 ≤ number of nodes ≤ 105
1 ≤ node->data ≤ 109

Expected Complexities
Time Complexity: O(n)
Auxiliary Space: O(h)
Company Tags
VMWareFlipkartAccoliteAmazonMicrosoftOYO RoomsSamsungSnapdealFactSetHikeMakeMyTripOla CabsWalmartGoldman SachsMAQ SoftwareAdobeLinkedinQualcommBoomerang CommerceGreyOrangeWookerNPCI
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
    Integer prev=null;
    
    public boolean isBST(Node root) {
       int i=check(root);
    return i==1;
    }
    
    public int check(Node root){
        if(root==null){
            return 1;
        }
        if (check(root.left) == 0) return 0;
        
        if(prev!=null&&prev>=root.data){
            return 0;
        }
        prev=root.data;
        return check(root.right);
        
    }
    
}