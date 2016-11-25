/**
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * 
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 * 
 * Here is an example of version numbers ordering:
 * 
 * 0.1 < 1.1 < 1.2 < 13.37
 * 
 * Result. "Your runtime beats 23.41% of java submissions."
 */
 
public class Solution {
    public int compareVersion(String version1, String version2) {
        
        if(version1 == null || version2 == null) return 0;
        
        String[] tokens1 = (version1.indexOf(".") > 0) ? version1.split("\\.") : new String[]{version1};
        String[] tokens2 = (version2.indexOf(".") > 0) ? version2.split("\\.") : new String[]{version2};
        
        int index1 = 0, index2 = 0;
        while(index1 < tokens1.length || index2 < tokens2.length) {
            
            if(index1 >= tokens1.length && Integer.parseInt(tokens2[index2]) != 0) return -1;
            if(index2 >= tokens2.length && Integer.parseInt(tokens1[index1]) != 0) return  1;
            
            if(index1 < tokens1.length && index2 < tokens2.length) {
                int res = Integer.parseInt(tokens1[index1]) - Integer.parseInt(tokens2[index2]);
                if(res < 0) return -1;
                else if(res > 0) return 1;
            }
            
            index1++;
            index2++;
        }
        return 0;
    }
}
