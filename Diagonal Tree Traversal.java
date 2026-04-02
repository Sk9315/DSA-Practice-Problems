/*
Given a Binary Tree, return the diagonal traversal of the binary tree.

Consider lines of slope -1 passing between nodes. Given a Binary Tree, return a single list containing all diagonal elements in a binary tree belonging to same line.
If the diagonal element are present in two different subtrees then left subtree diagonal element should be taken first and then right subtree. 

Examples :

Input : root = [8, 3, 10, 1, 6, N, 14, N, N, 4, 7, 13]

Output : [8, 10, 14, 3, 6, 7, 13, 1, 4]
Explanation:

Diagonal Traversal of binary tree : 8 10 14 3 6 7 13 1 4
Input: root = [1, 2, N, 3, N]

Output: [1, 2, 3]
Constraints:
1 <= number of nodes<= 105
1 <= node->data <= 105

Expected Complexities
Company Tags
AmazonMicrosoft
 */
 import java.util.*;
 /* Node is defined as
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}*/
class Tree {
    public ArrayList<Integer> diagonal(Node root) {
        
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        findDiag(root, 0, hm);
        
        for (ArrayList<Integer> list : hm.values()) {
            ans.addAll(list);
        }
        
        return ans;
    }
    
    public void findDiag(Node root, int pos, HashMap<Integer, ArrayList<Integer>> hm) {
        if (root == null) {
            return;
        }
        
        hm.putIfAbsent(pos, new ArrayList<>());
        hm.get(pos).add(root.data);
        
        findDiag(root.left, pos + 1, hm);
        findDiag(root.right, pos, hm);
    }
}