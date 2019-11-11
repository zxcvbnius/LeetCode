class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        // init counter
        HashMap<String, Integer> counter = new HashMap<>();
        for(String word : words) {
            Integer count = counter.get( word );
            if( count == null ) count = 0;
            counter.put( word, ++count);
        }
        
        // dump data from counter to res
        HashMap<Integer, Set<String>> res = new HashMap<>();
        for(String word : counter.keySet() ) {
            int count = counter.get( word );

            Set<String> set = res.get( count );
            if( set == null ) {
                set = new TreeSet<>();
                res.put( count, set );
            }
            set.add( word );
        }
        
        List<String> ans = new ArrayList<>();
        for(int i = words.length - 1 ; i >= 1 ; i--) {
            if( res.get(i) == null ) continue;
            while( res.get(i).size() > 0 && ans.size() < k) {
                String w = res.get(i).iterator().next();
                res.get(i).remove(w);
                ans.add(w);
            }
        }
        
        return ans;
    }
}
