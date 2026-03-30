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
        // Code
        Stack<Node>st=new Stack<>();
        ArrayList<Integer>al =new ArrayList<>();
        Node temp=root;
        while(temp!=null||st.size()>0){
            if(temp!=null){
                st.push(temp);
                temp=temp.left;
            }
            else{
                temp=st.peek();
                st.pop();
                al.add(temp.data);
                temp=temp.right;
            }
        }
        
        
        
        
        return al;
        
        
        
        
        
        
    }
}