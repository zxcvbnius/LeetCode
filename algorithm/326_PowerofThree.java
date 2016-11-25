/**
 * Given an integer, write a function to determine if it is a power of three.
 */
 
 // Using loop
 // Result. "Your runtime beats 50.90% of java submissions."
 public class Solution {
    public boolean isPowerOfThree(int n) {
        while( n >= 3) {
            if(n % 3 != 0) return false;
            n /= 3;
        }
        return n == 1;
    }
}

// Not using loop
// Result. "Your runtime beats 70.94% of java submissions."
public class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0) return false;
        int max3PowerInt = 1162261467; // 3^19, 3^20 = 3486784401 > MaxInt32
        
        if(n > max3PowerInt) return false;
        return max3PowerInt % n == 0;
    }
}
