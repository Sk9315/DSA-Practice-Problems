/*
Given a string s, composed of different combinations of '(' , ')', '{', '}', '[', ']'. Determine whether the Expression is balanced or not.
An expression is balanced if:

Each opening bracket has a corresponding closing bracket of the same type.
Opening brackets must be closed in the correct order.
Examples :

Input: s = "[{()}]"
Output: true
Explanation: All the brackets are well-formed.
Input: s = "[()()]{}"
Output: true
Explanation: All the brackets are well-formed.
Input: s = "([]"
Output: false
Explanation: The expression is not balanced as there is a missing ')' at the end.
Input: s = "([{]})"
Output: false
Explanation: The expression is not balanced as there is a closing ']' before the closing '}'.
Constraints:
1 ≤ s.size() ≤ 106
s[i] ∈ {'{', '}', '(', ')', '[', ']'}

Expected Complexities
Time Complexity: O(n)
Auxiliary Space: O(n)
Company Tags
FlipkartAmazonMicrosoftOYO RoomsSnapdealOracleWalmartAdobeGoogleYatra.com

*/
import java.util.*;
class Solution {
    public boolean isBalanced(String s) {
        // code here
        HashMap<Character,Character>hm=new HashMap<>();
        int n=s.length();
        hm.put(')','(');
        hm.put(']','[');
        hm.put('}','{');
        
        Stack<Character>st=new Stack<>();
        
       for(int i=0;i<n;++i){
           if(!st.isEmpty()){
               if(st.peek().equals(hm.get(s.charAt(i)))){
                   st.pop();
               }
               else{
                   st.push(s.charAt(i));
               }
           }
           else{
               st.push(s.charAt(i));
           }
       }
       return st.size()>0?false:true;
    }
}
