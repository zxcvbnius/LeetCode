/**
 * Given a string, sort it in decreasing order based on the frequency of characters.
 * Input:
 *   "tree"
 * 
 * Output:
 *   "eert"
 * 
 * Explanation:
 *   'e' appears twice while 'r' and 't' both appear once.
 *   So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 *
 * Result. "Your runtime beats 78.71% of java submissions."
 */
 public class Solution {
    public String frequencySort(String s) {
        
        String res = "";
        
        char[] chars = s.toCharArray();
        if(chars.length == 0) return res;
        
        Arrays.sort(chars);
        
        HashMap<Character, Integer> counts = new HashMap<>();
        {
            char curChar = chars[0];
            int count    = 1;
            for(int i = 1 ; i < chars.length ; i++) {
                if(curChar == chars[i]) count++;
                else {
                    counts.put(curChar, count);
                    curChar = chars[i];
                    count   = 1;
                }
            }
            counts.put(curChar, count);
        }
        
        List<Character>[] bucket = new ArrayList[ chars.length + 1 ];
        for( char ch : counts.keySet() ) {
            int count = counts.get(ch);
            if(bucket[count] == null) bucket[count] = new ArrayList<>();
            bucket[count].add(ch);
        }
        
        for(int i = chars.length ; i >= 0 ; i-- ) {
            if(bucket[i] != null) {
                for(char ch : bucket[i]) {
                    char[] repeat = new char[i];
                    Arrays.fill(repeat, ch);
                    res += new String(repeat);
                    
                }
            }
        }
        return res;
        
    }
}
 
 
