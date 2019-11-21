class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(String s: strings) {
            String key = getShiftKey(s);

            List<String> list = map.get( key );
            if( list == null ) {
                list = new ArrayList<>();
                map.put( key, list );
            }
            list.add(s);
        }
        
        List<List<String>> res = new LinkedList<>();
        for( String key : map.keySet() ) {
            List<String> list = map.get( key );
            Collections.sort( list );
            res.add( list );
        }

        return res;
    }
    
    public String getShiftKey(String s) {
        StringBuilder sb = new StringBuilder();
        int offset = s.charAt(0) - 'a';
        
        for( char ch : s.toCharArray() ) {
            char val = (char) (ch - offset);
            if(val < 'a' ) val += 26;
            sb.append( (char)(val + 'a') );
        }
        
        return sb.toString();
    }
}
