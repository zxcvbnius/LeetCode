class Solution {
    public int titleToNumber(String s) {
        if(s == null || s.length() == 0 ) return 0;
        
        char[] sCharArray = s.toCharArray();
        int result = 0;

        int base = 1;
        for(int i = sCharArray.length - 1 ; i >= 0 ; i--) {
            char curChar = sCharArray[i];
            int val = (curChar - 'A') + 1;
            
            result += val * base;
            
            base *= 26;
        }
        
        return result;
    }
}
