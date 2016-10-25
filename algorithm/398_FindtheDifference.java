public class Solution {
    public char findTheDifference(String s, String t) {
	        int sLen = s.length();
	        int tLen = t.length();
	        
	        char[] sArray = new char[sLen];
	        for(int i = 0 ; i < sLen ; i++) {
	        	sArray[i] = s.charAt(i);
	        }
	        
	        char[] tArray = new char[tLen];
	        for(int i = 0 ; i < tLen ; i++) {
	        	tArray[i] = t.charAt(i);
	        }
	        
	        Arrays.sort(sArray);
	        Arrays.sort(tArray);
	            
	        int len  = sLen > tLen ? sLen : tLen;
	        
	        for(int i = 0 ; i < len; i++) {
	            if(sLen - 1 < i) {
	                return tArray[i];
	            } else if (tLen - 1 < i) {
	                return sArray[i];
	            } else {
	                if(sArray[i] != tArray[i]) {
	                    if(len == sLen) {
	                        return sArray[i];
	                    } else {
	                        return tArray[i];
	                    }
	                }
	            }
	        }
	        return (Character) null;
	    }
}
