class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {

        if( words1.length != words2.length ) return false;

        HashMap<String, Set<String>> map = new HashMap<>();

        // init map
        for(int i = 0 ; i < pairs.size() ; i++ ) {
            String p1 = pairs.get(i).get(0), p2 = pairs.get(i).get(1);

            if( map.get(p1) == null ) map.put( p1, new HashSet<>() );
            if( map.get(p2) == null ) map.put( p2, new HashSet<>() );

            map.get(p1).add(p2);
            map.get(p2).add(p1);
        }

        int len = words1.length;
        for(int i = 0 ; i < len ; i++) {
            String w1 = words1[i], w2 = words2[i];

            if( w1.equals(w2) ) continue;
            if( map.get(w1) == null || map.get(w2) == null ) return false;
            if( !isSimilar( w1, w2 , map, new HashSet<>()) ) return false;
        }
        return true;
    }

    public boolean isSimilar(String w1, String w2, HashMap<String, Set<String>> map, HashSet<String> visited ) {
        if( map.get(w1).contains(w2) ) return true;

        visited.add(w1);

        for(String key : map.get(w1) ) {
            if( !visited.contains(key) && isSimilar( key, w2, map, visited ) ) return true;
        }
        return false;
    }
}
