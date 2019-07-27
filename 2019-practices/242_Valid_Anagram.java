class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;
        
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        
        int len = sChars.length;

        int[] results = new int[256]; // element default value is zero
        
        for(int i = 0 ; i < len ; i++) {
            results[ sChars[i] ] += 1;
        }
        
        for(int i = 0 ; i < len ; i++) {
            results[ tChars[i] ] -= 1;
        }
        
        for(int i = 0 ; i < 256; i++) {
            if( results[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
}
