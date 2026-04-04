/*
Given two binary strings s1 and s2 consisting of only 0s and 1s. Find the resultant string after adding the two Binary Strings.
Note: The input strings may contain leading zeros but the output string should not have any leading zeros.

Input: s1 = "1101", s2 = "111"
Output: 10100
Explanation:
 1101
+ 111
10100
Input: s1 = "00100", s2 = "010"
Output: 110
Explanation: 
  100
+  10
  110
Constraints:
1 ≤s1.size(), s2.size()≤ 106

Expected Complexities
Company Tags
AmazonMicrosoftFacebook
*/
#include <bits/stdc++.h>
using namespace std;
class Solution {
    public String addBinary(String s1, String s2) {
        StringBuilder result = new StringBuilder();

        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;

        // Add from right to left
        while (i >= 0 || j >= 0 || carry == 1) {
            int bit1 = (i >= 0) ? s1.charAt(i) - '0' : 0;
            int bit2 = (j >= 0) ? s2.charAt(j) - '0' : 0;

            int sum = bit1 + bit2 + carry;
            carry = sum / 2;
            int bit = sum % 2;

            result.append(bit);

            i--;
            j--;
        }

        // Reverse the result string because we added bits from right to left
        result.reverse();

        // Remove leading zeros if any
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.toString();
    }
}