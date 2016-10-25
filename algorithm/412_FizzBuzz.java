public class Solution {
    public List<String> fizzBuzz(int n) {
     ArrayList<String> res = new ArrayList<>(n);
     for(int i = 1 ; i < n + 1; i++)
        if(i % 15 == 0 ) {
            res.add("FizzBuzz");
        } else if( i % 5 == 0) {
            res.add("Buzz");
        } else if( i % 3 == 0) {
            res.add("Fizz");
        }else {
            res.add(String.valueOf(i));
        }
    
      return res;
    }
    
}
