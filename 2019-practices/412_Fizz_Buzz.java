class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> results = new LinkedList<>();
        for(int i = 1; i <= n ; i++ ) {

            boolean is_dived_by_3 = (i % 3 == 0);
            boolean is_dived_by_5 = (i % 5 == 0);

            if(is_dived_by_3 && is_dived_by_5) {
                results.add("FizzBuzz");
            } else if (is_dived_by_5) {
                results.add("Buzz");
            } else if (is_dived_by_3) {
                results.add("Fizz");
            } else {
                results.add( String.valueOf(i) );
            }
        }
        return results;
    }
}
