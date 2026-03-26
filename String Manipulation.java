/*
Tom is a string freak. He has got sequences of words arr[] to manipulate. If in a sequence, two same words come together then Tom destroys each other. Find the number of words left in the sequence after this pairwise destruction. 

Examples:

Input: arr[] = ["ab", "aa", "aa", "bcd", "ab"]
Output: 3
Explanation: After the first iteration, we'll have: ab bcd ab. We can't further destroy more strings and hence we stop and the result is 3. 
Input: arr[] = ["tom", "jerry", "jerry", "tom"]
Output: 0
Explanation: After the first iteration, we'll have: tom tom. After the second iteration: 'empty-array' .Hence, the result is 0.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 ≤ arr.size() ≤106
1 ≤ |arri| ≤ 50

*/
import java.util.*;

class Solution {
    static int removeConsecutiveSame(String[] arr) {
        // Your code goes here
        int n=arr.length;
        Stack<String>st=new Stack<>();
        for(int i=0;i<n;++i){
            if(!st.isEmpty()){
                if(st.peek().equals(arr[i])){
                    st.pop();
                }
                else{
                    st.push(arr[i]);
                }
            }
            else{
                st.push(arr[i]);
                
            }
        }
        return st.size();
    }
}