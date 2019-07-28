class Solution {
    public int[] plusOne(int[] digits) {
        int plusOne = 1; // 0: false, 1: true
        
        int len = digits.length;
        
        for(int i = len - 1 ; i >= 0 ; i--) {
            digits[i] += plusOne;
            if(digits[i] >= 10) {
                plusOne = 1;
                digits[i] -= 10;
            } else {
                plusOne = 0;
            }
            
            if(plusOne == 0) break;
        }
        
        if(plusOne == 0) return digits;
        
        int[] result = new int[ len + 1];
        result[0] = 1;
        for(int i = 0 ; i < len ; i++) {
            result[ i + 1] = digits[i];
        }
        
        return result;
    }
}
