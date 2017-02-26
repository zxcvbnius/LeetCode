/**
 * Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.
 * Note:
 * Input contains only lowercase English letters.
 * Input is guaranteed to be valid and can be transformed to its original digits. That means invalid inputs such as "abc" or "zerone" are not permitted.
 * Input length is less than 50,000.
 * Example 1:
 *   Input: "owoztneoer"
 *   Output: "012"
 * Result. "Your runtime beats 83.24% of java submissions."
 */
 public class Solution {
    public String originalDigits(String s) {
        // a: 97, z: 122
        int[] counts = new int[26];
        char[] array = s.toCharArray();
		for( char ch : array) counts[ch - 97]++;
		
		int[] index = {0, 2, 8, 3, 4, 5, 6, 9, 7, 1};
		
		int[][] digitalToChar = {
				{25, 4, 17, 14}, // zero
				{19, 22, 14}, // two
				{4, 8, 6, 7, 19}, // eight
				{19, 7, 17, 4, 4}, // three
				{5, 14, 20, 17}, // four
				{5, 8, 21, 4}, // five
				{18, 8, 23}, // six
				{13, 8, 13, 4}, // nine
				{18, 4, 21, 4, 13}, // seven
				{14, 13, 4} // one
		};
		
		int[] result = new int[10];
		
		for(int i = 0 ; i < digitalToChar.length ; i++) {
			int[] chIndex = digitalToChar[i];
			while(true) {
				boolean hasValue = true;
				for(int j = 0 ; j < chIndex.length ; j++) {
					if( counts[chIndex[j]] <= 0 ) hasValue = false;
				}
				if(!hasValue) break;
				else {
					for(int j = 0 ; j < chIndex.length ; j++) {
						counts[chIndex[j]]--;
					}
					result[index[i]]++;
				}
			}
		}
		StringBuilder builder = new StringBuilder();
		for(int i = 0 ; i < result.length ; i++) {
		    while(result[i] > 0) {
		        builder.append( String.valueOf(i) );
		        result[i]--;
		    }
		}
        return builder.toString();
    }
}
