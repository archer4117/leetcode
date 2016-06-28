/*

* Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

* For example:

* Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

* Follow up:
* Could you do it without any loop/recursion in O(1) runtime?

*/
// the digital root of 11 is 2, which means that 11 is the second number after 9.
// Likewise, the digital root of 2035 is 1, which means that 2035 − 1 is a multiple of 9. 
// If a number produces a digital root of exactly 9, then the number is a multiple of 9.

public class Solution {
    public int addDigits(int num) {
        return (num-1)%9+1;
    }
}
