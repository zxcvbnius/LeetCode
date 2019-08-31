class Solution {
    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        for(char ch : chars) {
            if(ch >= (int) 'A' && ch <= (int)'Z' ) {
                sb.append( (char)(ch - 'A' + 'a') );
            } else {
                sb.append( ch );
            }
        }
        return sb.toString();
    }
}
