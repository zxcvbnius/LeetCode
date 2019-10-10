class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // find the ans of nums2
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = nums2.length - 1 ; i >= 0 ; i--) {
            while( !stack.isEmpty() && stack.peek() <= nums2[i] ) {
                stack.pop();
            }
            if( stack.isEmpty() ) {
                map.put( nums2[i], -1);
            } else {
                map.put( nums2[i], stack.peek());
            }
            stack.push(nums2[i]);
        }
        
        int[] ans = new int[ nums1.length];
        for(int i = 0 ; i < ans.length ; i++) {
            ans[i] = map.get( nums1[i] );
        }
        
        return ans;

    }
}
