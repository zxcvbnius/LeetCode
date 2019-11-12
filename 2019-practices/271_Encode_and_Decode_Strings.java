public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        int size = strs.size();

        for(int i = 0 ; i < size ; i++) {
            String word = strs.get(i);
            sb.append( word.length() ).append(':').append(word);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> list = new ArrayList<>();
        int idx = 0, size = s.length();

        while( idx < size ) {
            int pos = s.substring(idx).indexOf(':') + idx;
            
            int len = Integer.parseInt( s.substring(idx, pos) );

            list.add( s.substring(pos + 1 , pos + len + 1) );
            idx = pos + len + 1;
        }
        
        return list;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
