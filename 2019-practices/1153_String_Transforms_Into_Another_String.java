class Solution {
    // HashMap to calculate convert char
    public boolean canConvert(String str1, String str2) {
        if( str1.equals(str2) ) return true;
        int len1 = str1.length(), len2 = str2.length();
        if( len1 != len2 ) return false;

        HashMap<Character, Character> map = new HashMap<>();

        int idx = 0;
        while( idx < len1 ) {
            char ch1 = str1.charAt(idx);
            char ch2 = str2.charAt(idx);
            if( map.containsKey(ch1)  ) {
                if( ch2 != map.get(ch1)  ) return false;
            } else {
                map.put( ch1, ch2 );
            }
            idx++;
        }

        return new HashSet<Character>(map.values()).size() < 26;
    }
}
