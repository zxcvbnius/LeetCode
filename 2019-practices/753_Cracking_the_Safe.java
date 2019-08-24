class Solution {
    String ans = null;
    public String crackSafe(int n, int k) {
        int target = (int) Math.pow(k, n);

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++) sb.append( 0 );

        dfs(sb, n, k, target, new HashSet<>());
        return ans;
    }
    
    public boolean dfs(StringBuilder sb, int n, int k, int target, Set<String> visited) {
        if( visited.size() == target) {
            ans = sb.substring( 1, sb.length() );
            return true;
        }
        
        int len = sb.length();
        String prev = sb.substring( len - n + 1, len );
        for(int i = 0 ; i < k ; i++) {
            String w = prev + i;
            if( !visited.contains(w) ) {
                sb.append( i );
                visited.add(w);
                boolean find = dfs(sb, n, k, target, visited);
                if(find) return true;
                visited.remove( w );
                sb.setLength( len );
            }
        }
        return false;
    }
}
