class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        char[] chars1 = num1.toCharArray(), chars2 = num2.toCharArray();
        int[] result = new int[ len1 + len2 ];

        for(int i = len1 - 1 ; i >= 0 ; i--) {
            for(int j = len2 - 1; j >= 0 ; j--) {
                int mul = (chars1[i] - '0') * (chars2[j] - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + result[ p2 ];
                
                result[p1] += sum / 10;
                result[p2] = sum % 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int ch : result) {
            if( ch == 0  && sb.length() == 0 ) continue;
            sb.append(ch);
        }
        return ( sb.length() == 0 ) ? "0" : sb.toString();
    }
}
