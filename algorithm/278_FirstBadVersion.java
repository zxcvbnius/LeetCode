/* The isBadVersion API is defined in the parent class VersionControl.
 boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        
        int index = -1;
        int start = 1;
        int end = n;
        //int count = 0;
        
        while(start+1 < end )
        {
            index = (start) + (end - start) /2 ;
            
            if( !isBadVersion(index) )
            {
                start = index;
            }
            else
            {
                end = index;
            }
        }
        
        if( isBadVersion(start) )
        {
            return start;
        }
        else if( isBadVersion(end) )
        {
            return end;
        }
        else
            return -1;
    }
    
    
}