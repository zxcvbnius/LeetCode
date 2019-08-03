/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        // socker read handler
        char[] tmp = new char[4]; 
        int prevPos = 0; // for tmp array
        int remaining = 0;
        int count = 0;
        
        while(n > 0) {
            if(remaining == 0) {
                prevPos = 0;
                remaining = read4(tmp);
                if(remaining == 0) break;
            }
            
            while(n > 0 && remaining > 0) {
                buf[count++] = tmp[prevPos++];
                remaining--;
                n--;
            }
        }
        
        return count;
    }
}
