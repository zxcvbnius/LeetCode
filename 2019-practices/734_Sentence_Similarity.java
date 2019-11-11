class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        if( words1.length != words2.length) return false;

        HashMap<String, Set<String>> map = new HashMap<>();
        
        int pSize = pairs.size();
        for(int i = 0 ; i < pSize ; i++) {
            String p1 = pairs.get(i).get(0);
            String p2 = pairs.get(i).get(1);
            
            Set<String> set = map.get(p1);
            if( set == null ) map.put( p1, new HashSet<>() );
            map.get( p1 ).add( p2 );
            
            set = map.get(p2);
            if( set == null ) map.put( p2, new HashSet<>() );
            map.get( p2 ).add( p1 );
        }
        
        int len = words1.length, ans = 0;
        for(int i = 0 ; i < len ; i++) {
            if( words1[i].equals(words2[i]) ) continue;
            if( !map.containsKey( words1[i] ) ) return false;
            if( !map.get( words1[i] ).contains( words2[i] ) ) return false;
        }
        
        return true;
    }
}
