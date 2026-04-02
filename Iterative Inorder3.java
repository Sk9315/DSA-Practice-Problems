/*
Given a binary tree. Find the inorder traversal of the tree without using recursion.

Examples

Input:  

Output: 4 2 5 1 3
Explanation:
Inorder traversal (Left->Root->Right) of 
the tree is 4 2 5 1 3.
Input:

Output: 1 7 10 8 6 10 5 6
Explanation:
Inorder traversal (Left->Root->Right) 
of the tree is 1 7 10 8 6 10 5 6.
 

Your task:
You don't need to read input or print anything. Your task is to complete the function inOrder() which takes the root of the tree as input and returns a list containing the inorder traversal of the tree, calculated without using recursion.

Expected time complexity: O(N)
Expected auxiliary space: O(N)


Constraints:
1 <= Number of nodes <= 105
1 <= Data of a node <= 105
Company Tags
Microsoft
*/
import java.util.*;
// User function Template for Java

/* A Binary Tree node

class Node {
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */
class Solution {
    // Return a list containing the inorder traversal of the given tree
    ArrayList<Integer> inOrder(Node root) {
     ArrayList<Integer>ans=new ArrayList<>();
     while(root!=null){
         if(root.left==null){
             ans.add(root.data);
             root=root.right;
         }
         else{
             Node curr=root.left;
             while(curr.right!=null && curr.right!=root){
                 curr=curr.right;
             }
             
             if(curr.right==null){
                 curr.right=root;
                 root=root.left;
             }
             else{
                 curr.right=null;
                 ans.add(root.data);
                 root=root.right;
             }
         }
     }
     return ans;
    }
}