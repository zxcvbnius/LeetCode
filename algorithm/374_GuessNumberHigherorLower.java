/**
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 * 
 * Result. "Your runtime beats 19.74% of java submissions :("
 */
/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int res = 0, low = 1, high = n;
        while(low <= high) {
            if(low == high) return low;
            
            int mid = (low /2 + high/2);
            
            int val = guess( mid );
            
            if(val == 0 ) return mid;
            else if(val == -1) {
                high = mid - 1;
            } else if(val == 1) {
                low = mid + 1;
            }
        }
        
        return low;
    }
}
