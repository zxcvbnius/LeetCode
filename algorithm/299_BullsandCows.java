/**
 * You are playing the following Bulls and Cows game with your friend: 
 * You write down a number and ask your friend to guess what the number is. 
 * Each time your friend makes a guess, you provide a hint that indicates how many digits 
 * in said guess match your secret number exactly in both digit and position (called "bulls") 
 * and how many digits match the secret number but locate in the wrong position (called "cows"). 
 * Your friend will use successive guesses and hints to eventually derive the secret number.
 *  For example:
 *    Secret number:  "1807"
 *    Friend's guess: "7810"
 *    Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
 *    Write a function to return a hint according to the secret number and friend's guess, 
 *    use A to indicate the bulls and B to indicate the cows. 
 *    In the above example, your function should return 
 *    "1A3B"
 */
 
 // Sol1. Using "Violence Solution", time complexity is very very bad (51ms)
 // Result. "Your runtime beats 3.67% of java submissions :("
 public class Solution {
    public String getHint(String secret, String guess) {
        
        int len = secret.length();
        boolean[] right = new boolean[len];
        boolean[] used  = new boolean[len];
        
        int a = 0;
        int b = 0;
        
        for(int i = 0 ; i < len ; i++) {
            right[i] = secret.charAt(i) == guess.charAt(i);
            if(right[i]) used[i] = true;
        }
        
        for(int i = 0 ; i < len ; i++) {
            if(right[i]) a++;
            else {
                for(int j = 0 ; j < len ; j++) {
                    if(i == j || used[j]) continue;
                    if(secret.charAt(i) == guess.charAt(j)) {
                        used[j] = true;
                        b++;
                        break;
                    }
                }
            }
        }
        return String.valueOf(a) + "A" + String.valueOf(b) + "B";
    }
}


 // Sol2. Covert Char to Integer, time complexity is O(N)
 public class Solution {
    public String getHint(String secret, String guess) {
        int len = secret.length();
        int[] s = new int[10];
        int[] g = new int[10];
        int a = 0, b = 0;
        for(int i = 0 ; i < len ; i++) {
            int sNum = Character.getNumericValue( secret.charAt(i) );
            int gNum = Character.getNumericValue( guess.charAt(i) );
            if(sNum == gNum) a++;
            else {
                if( g[sNum] > 0 ) {
                    b++;
                    g[sNum]--;
                    s[sNum]--;
                } 
                if(s[gNum] > 0) {
                    b++;
                    s[gNum]--;
                    g[gNum]--;
                } 
                s[sNum]++;
                g[gNum]++;
            }
        }
        return a + "A" + b + "B";
    }
}
