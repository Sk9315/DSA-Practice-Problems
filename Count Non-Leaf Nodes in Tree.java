/*
Given a Binary Tree of size n, your task is to return the count of all the non-leaf nodes of the given binary tree.

Example:

Input: 
Image
Output: 2
Explanation: Nodes 1 and 2 are the only non leaf nodes.
Input: 
          8
        /   \
       3     9
      / \
     1   6
        / \
       4   7
Output: 3
Explanation: Nodes 8, 3 and 6 are the only non leaf nodes.
Input: 
          10
        /    \
      5       20
     / \     /  \
    3   7   15   25
Output: 3
Explanation: Nodes 10, 5 and 20 are the only non leaf nodes.
Constraints:
1 ≤ number of nodes ≤ 105
1 ≤ node->data ≤ 105


*/

import java.util.*;
/*class Node
{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}*/

// function should return the count of total number of non leaf nodes in the tree.
class Solution {
    int countNonLeafNodes(Node root) {
        // code here
         // Your code
        if(root==null){
            return 0;
        }
        if(root.left==null&& root.right==null){
            return 0;
        }
        return (1+ countNonLeafNodes(root.left)+countNonLeafNodes(root.right));
    }
}