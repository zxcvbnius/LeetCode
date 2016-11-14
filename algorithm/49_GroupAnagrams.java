/**
 * Given an array of strings, group anagrams together.
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
 * Return:
 * [
 *   ["ate", "eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *  
 * Result. "Your runtime beats 90.26% of java submissions"
 */
 
 public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> res = new ArrayList<>();
        
        HashMap<String, ArrayList<String>> keys = new HashMap<>();
        for(int i = 0 ; i < strs.length ; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            
            ArrayList<String> list = keys.get(key);
            if(list == null) {
                list = new ArrayList<>();
                list.add(strs[i]);
                keys.put(key, list);
            } else {
                list.add(strs[i]);
                keys.put(key, list);
            }
        }   
        
        for(String key : keys.keySet() ) {
            res.add(keys.get(key));
        }
        
        return res;
    }
}
