public class Solution {
    
    public int addDigits(int num) {
        
        int result = 0;
        while(num >= 10 ) {
            result = add( num % 10, (num / 10) % 10 );
            num = num / 100 + result;
        }
        //result = add(result, num);
        
        return num;
        
    }
    
    public int add(int a, int b) {
        int sum = a + b;
        if( sum < 10 ) {
            return sum;
        }
        else return add( (sum) / 10 , (sum) % 10 );
    }
    
    /*
    public int addDigits(int num) {
        
        
        if(num <= 0 )
            return num;
        
        String numStr = Integer.toString(num);
        int sum = 0;
        for (int i = 0; i < numStr.length(); i++)
        {
            int intValue = (int) numStr.charAt(i) - 48;
            sum += intValue;
        }
        
        int ans = sum % 9 ;
        if(ans == 0 ) ans = 9;
        
        return ans;
    }
    */
}
