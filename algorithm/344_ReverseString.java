public class Solution {
    public String reverseString(String s) {
    int len = s.length();
    char[] temp = new char[len];
    for(int i = 0; i < len ; i++) {
      temp[len - i - 1] = s.charAt(i);
    }
    return String.valueOf(temp);
  }
}
