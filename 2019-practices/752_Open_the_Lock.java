class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> candidates = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        int count = 0;

        candidates.offer( "0000" );

        for(String deadend : deadends) visited.add( deadend );

        while( candidates.size() > 0 ) {
            Queue<String> tmp = new LinkedList<>();
            while( candidates.size() > 0 ) {
                String candidate = candidates.poll();

                if( visited.contains(candidate) ) continue;
                visited.add( candidate );

                if( target.equals(candidate) ) return count;

                List<String> list = getNextCandidates(candidate);
                for(String next : list) tmp.offer( next );
            }
            count++;
            candidates = tmp;
        }

        return -1;
    }

    public List<String> getNextCandidates(String cur) {
        List<String> candidates = new LinkedList<>();
        for(int i = 0 ; i < 4; i++) {
            char p1 = (char)(cur.charAt(i) == '9' ? '0' : cur.charAt(i) + 1);
            char p2 = (char)(cur.charAt(i) == '0' ? '9' : cur.charAt(i) - 1);
            candidates.add( cur.substring(0, i) + p1 + cur.substring(i + 1, 4) );
            candidates.add( cur.substring(0, i) + p2 + cur.substring(i + 1, 4) );
        }
        return candidates;
    }
}
