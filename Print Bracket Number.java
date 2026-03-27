/*
Given a string str, the task is to find the bracket numbers, i.e., for each bracket in str, return i if the bracket is the ith opening or closing bracket to appear in the string. 

 Examples:

Input:  str = "(aa(bdc))p(dee)"
Output: 1 2 2 1 3 3
Explanation: The highlighted brackets in
the given string (aa(bdc))p(dee) are
assigned the numbers as: 1 2 2 1 3 3.
Input:  str = "(((()("
Output: 1 2 3 4 4 5
Explanation: The highlighted brackets in
the given string (((()( are assigned
the numbers as: 1 2 3 4 4 5
Expected Time Complexity: O(|str|)
Expected Auxiliary Space: O(|str|)

Constraints:
1 <= |str| <= 105
str contains lowercase English alphabets, and '(', ')' characters
At any index, the number of opening brackets is greater than or equal to closing brackets

Company Tags
Flipkart
*/
import java.util.*;
// User function Template for Java

class Solution {
    ArrayList<Integer> bracketNumbers(String str) {
        // code here
        int count=0;
        Stack<Integer> st=new Stack<>();
        ArrayList<Integer>al=new ArrayList<>();
        
        int n=str.length();
        for(char ch:str.toCharArray()){
            
          
            if(ch=='('){
                count++;
                al.add(count);
                st.push(count);
            }
            
            
            else if(ch==')'){
                al.add(st.peek());
                st.pop();
                
            }
        }
        return al;
    }
};