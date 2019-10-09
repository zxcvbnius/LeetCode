/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int lo = 0, hi = n;
        while( lo < hi ) {
            int mid = ( hi - lo ) / 2 + lo;
            if( isBadVersion(mid) ) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
