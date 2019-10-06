class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int max = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < arr.length ; i++) {
            Integer val = map.get( arr[i] - difference );
            if( val == null ) {
                map.put( arr[i], 1);
            } else {
                int newVal = 1 + val;
                map.put( arr[i], newVal );
                if(max < newVal) max = newVal;
            }
        }
        return max;
    }
}
