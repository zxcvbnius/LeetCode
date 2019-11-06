class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();

        char[] chars = input.toCharArray();
        for(int i = 0 ; i < chars.length ; i++) {
            char ch = chars[i];
            if( ch == '-' || ch == '+' || ch == '*' ) {
                List<Integer> left = diffWaysToCompute( input.substring(0, i)  );
                List<Integer> right = diffWaysToCompute( input.substring(i+1)  );

                for(int l : left) {
                    for(int r : right) {
                        if( ch == '-' ) res.add( l - r );
                        else if( ch == '+' ) res.add( l + r );
                        else if( ch == '*' ) res.add( l * r );
                    }
                }
            }
        }
        if( res.size() == 0 ) res.add( Integer.parseInt( input ) );
        return res;
    }
}
