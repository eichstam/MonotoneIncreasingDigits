/*
Monotone Increasing Digits

Given a non-negative integer N, find the largest number that is less than
or equal to N with monotone increasing digits.

(Recall that an integer has monotone increasing digits if and only if each
pair of adjacent digits x and y satisfy x <= y.)

Example 1:
Input: N = 10
Output: 9

Example 2:
Input: N = 1234
Output: 1234

Example 3:
Input: N = 332
Output: 299

Note: N is an integer in the range [0, 10^9].
*/
    
public class Solution {
  public int numberOfDigits(int N) {
    int count = 0;
    String numStr = "" + N;

    if(numStr.length() == 1) {
      count = 1;
    } else {
      for(int i = 0; i < (numStr.length() - 1); i++) {
        if(numStr.charAt(i) <= numStr.charAt(i+1)) {
          count++;
        } else {
          count = 0;
          break;
        }
      }
    }
    return count;
  }

  public int monotoneIncreasingDigits(int N) {
    int max = 0;
    int maxLen = 0;
    String numStr = "" + N;
    int length = numStr.length();

    for(int i = N; i > 0; i--) {
      if(numberOfDigits(i) > maxLen) {
        maxLen = numberOfDigits(i);
        max = i;
        if(maxLen == length) {
          break;
        }
      }
    }
    return max;
  }
  
  static public void main(String[] args) {
    Solution s = new Solution();
    int n = 10;
    
    System.out.println("n=" + n + " largest=" + s.monotoneIncreasingDigits(n));
    n = 1234;
    System.out.println("n=" + n + " largest=" + s.monotoneIncreasingDigits(n));
    n = 332;
    System.out.println("n=" + n + " largest=" + s.monotoneIncreasingDigits(n));
    n = 348707;
    System.out.println("n=" + n + " largest=" + s.monotoneIncreasingDigits(n));
    
    // TODO: improve performance by implementing this hint
    // Hide Hint 1  
    // Build the answer digit by digit, adding the largest possible one
    // that would make the number still less than or equal to N.
    
  }
}
