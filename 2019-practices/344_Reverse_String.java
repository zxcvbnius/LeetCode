class Solution {
    public void reverseString(char[] s) {
        if(s == null) return ;
        
        int len = s.length;
        int left_index = 0;
        int right_index = len - 1;
        while(left_index < right_index) {
            char tmp = s[left_index];
            s[left_index] = s[right_index];
            s[right_index] = tmp;
            left_index ++;
            right_index --;
        }
    }
}
