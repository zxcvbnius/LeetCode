/**
 * We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.
 * 
 * Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
 * Example:
 * Input: 28
 * Output: True
 * Explanation: 28 = 1 + 2 + 4 + 7 + 14
 * Note: The input number n will not exceed 100,000,000. (1e8)
 */
 public class Solution {
    public boolean checkPerfectNumber(int num) {
        // find sqrt int
        if(num == 1 || num < 0) return false;
        
        // Next Guess = ( ( Guess^2) + N ) / ( 2 × Guess )
        double guess = num;
        while(Math.abs(guess * guess - num) > 1) {
            guess = ( (guess * guess) + num ) / (2 * guess);
        }
        int index = (int)Math.floor(guess);
        
        Set<Integer> sets = new HashSet<>();
        for(int i = index ; i > 1; i--) {
            if(num % i == 0) {
                int val1 = i;
                int val2 = (num / i);
                sets.add(val1);
                sets.add(val2);
            }
        }
        int sum = 1; // 1 for 1 * num
        for(int val : sets) {
            sum += val;
        }
        return sum == num;
    }
}
