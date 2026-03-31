/*
Given two arrays representing the inorder and postorder traversals of a binary tree, your task is to construct the binary tree and return its root.

Note: The inorder and postorder traversals contain unique values, and every value present in the postorder traversal is also found in the inorder traversal.

Examples:

Input: inorder[] = [4, 8, 2, 5, 1, 6, 3, 7], postorder[] = [8, 4, 5, 2, 6, 7, 3, 1]
Output: [1, 2, 3, 4, 5, 6, 7, N, 8]
Explanation: For the given inorder and postorder traversal of tree the resultant binary tree will be:

Input: inorder[] = [9, 5, 2, 3, 4], postorder[] = [5, 9, 3, 4, 2]
Output: [2, 9, 4, N, 5, 3]
Explanation: The resultant binary tree will be: 

Constraints:
1 ≤ number of nodes ≤ 103
0 ≤ inorder[i], postorder[i] ≤ 106

Expected Complexities
Company Tags
AmazonMicrosoftHikeAdobe
*/
import java.util.*;
/*
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/
import java.util.*;
class Solution {
    public static Node Tree(int inorder[],int postorder[],HashMap<Integer, Integer> hm,int inStart,int inEnd,int index){
        if(inStart>inEnd){
            return null;
        }
        Node root=new Node(postorder[index]);
        int pos=hm.get(postorder[index]);
        
         //build right part
        root.right=Tree(inorder,postorder,hm,pos+1,inEnd,index-1);
        
        //build left part
        root.left=Tree(inorder,postorder,hm,inStart,pos-1,index - (inEnd - pos) - 1);
       
        return root;
    }
    
    // public static int find(int inorder[],int target,int start,int end){
    //     for(int i=start;i<=end;++i){
    //         if(inorder[i]==target){
    //             return i;
    //         }
    //     }
    //     return -1;
    // }
    Node buildTree(int[] inorder, int[] postorder) {
        // code here
        HashMap<Integer,Integer>hm=new HashMap<>();
        int n=inorder.length;
        for(int i=0;i<n;++i){
           hm.put(inorder[i], i);
        }
        return Tree(inorder,postorder,hm,0,n-1,n-1);
        
    }
}