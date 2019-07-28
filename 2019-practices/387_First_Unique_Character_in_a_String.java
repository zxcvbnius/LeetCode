class Solution {
    public int firstUniqChar(String s) {
        if (s == null) return -1; // doesn't exit

        int[] record  = new int[256];
        char[] sCharArray = s.toCharArray();
        for(int i = 0 ; i < sCharArray.length ; i++ ) {
            record[ sCharArray[i] ]++;
        }
        
        for(int i = 0; i < sCharArray.length ; i++) {
            if(record[sCharArray[i]] == 1) {
                return i;
            }
        }
        
        return -1;
        
    }
}
