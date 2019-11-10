/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int lo = 1, hi = n;
        int mid = 1;

        while( true ) {
            mid = ( hi - lo ) / 2 + lo;
            int res = guess(mid);
            if( res == 0 ) break;
            else if( res == -1) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return mid;
    }
}
