/**
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 *   a = "11"
 *   b = "1"
 *   Return "100".
 * Result. "Your runtime beats 82.64% of java submissions"
 */
 // Avoid string1 = string1 + string2
 public class Solution {
    public String addBinary(String a, String b) {
        
        if(a == null && b == null) return null;
        else if(a == null) return b;
        else if(b == null) return a;
        
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        int aIndex = aChars.length - 1;
        int bIndex = bChars.length - 1;
        
        int len = aIndex > bIndex ? aIndex : bIndex;
        char[] res = new char[len + 1];
        int index  = len;
        
        boolean addOne = false;
        while(aIndex >= 0 || bIndex >= 0) {
            int val = (addOne ? 1 : 0);
            
            if(aIndex < 0) {
                val += (bChars[bIndex] == '0') ? 0 : 1;
                bIndex--;
            } else if(bIndex < 0) {
                val += (aChars[aIndex] == '0') ? 0 : 1;
                aIndex--;
            } else {
                val += ((aChars[aIndex] == '0') ? 0 : 1) + ((bChars[bIndex] == '0') ? 0 : 1);
                aIndex--;
                bIndex--;
            }
            if(val == 3) {
                addOne = true;
                res[index] = '1';
            } else if(val == 2) {
                addOne = true;
                res[index] = '0';
            } else {
                addOne = false;
                res[index] = val == 1 ? '1' : '0' ;
            }
            index--;
        }
        return addOne ? "1" + new String(res) : new String(res);
    }
}
