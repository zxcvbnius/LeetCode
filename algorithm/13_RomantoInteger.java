/**
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * Result. "Your runtime beats 89.25% of java submissions."
 */
 public class Solution {
    public int romanToInt(String s) {
        int res = 0;
        
        if(s == null) return res;          
        
        char[] chars = s.toCharArray();
        for(int i = 0 ; i < chars.length ; i++ ) {
            
            if( i > 0 && getValue(chars[i]) > getValue(chars[i-1]) ) {
                res += getValue(chars[i]) - 2*getValue(chars[i-1]);
            } else {
                res += getValue(chars[i]);
            }
        }
        return res;
    }
    public int getValue(char ch) {
        switch(ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            
        }
        return 0;
    }
}
