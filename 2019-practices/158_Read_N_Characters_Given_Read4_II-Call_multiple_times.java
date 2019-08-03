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
    int prevPos = 0;
    int remaining = 0;
    char[] tmp = new char[4];
    
    public int read(char[] buf, int n) {
        // it seems like socket reader
        int count = 0;
        while(n > 0) {
            while(n > 0 && remaining > 0) {
                buf[count++] = tmp[prevPos++];
                remaining--;
                n--;
            }
            
            if(n > 0) {
                prevPos = 0;
                remaining = read4(tmp);
                if(remaining == 0) break;
                
            }
        }
        
        return count;
    }
}
