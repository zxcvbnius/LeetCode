class Solution {
    public String[] expand(String S) {
        ArrayList<String> list = new ArrayList<>();
        
        char[] sChar = S.toCharArray();
        int len = sChar.length;
        
        for(int i = 0 ; i < len ; i++) {
            char ch = sChar[i];

            if(ch == '{') {
                int j = i + 1;
                StringBuilder sb = new StringBuilder();
                while( j < len && sChar[j] != '}') {
                    if( sChar[j] == ',' ) {
                        // pass
                    } else {
                        sb.append( sChar[j] );
                    }
                    j++;   
                }
                list.add( sb.toString() );
                i = j;
            } else {
                list.add("" + ch);
            }
        }
        
        ArrayList<String> results = new ArrayList<>();
        dfs(list, results, 0, new StringBuilder());
        
        String[] array = results.toArray( new String[results.size()] );
        Arrays.sort(array);
        return array;
        
    }
    
    public void dfs(ArrayList<String> list, ArrayList<String> results, int listOfPos, StringBuilder sb) {
        if(listOfPos == list.size() ) {
            results.add( sb.toString() );
            return;
        }
        char[] array = list.get( listOfPos ).toCharArray();
        for(int i = 0 ; i < array.length ; i++) {
            sb.append( array[i] );
            dfs(list, results, listOfPos + 1, new StringBuilder(sb));
            sb.setLength( sb.length() - 1);
        }
        return;
    }
}
