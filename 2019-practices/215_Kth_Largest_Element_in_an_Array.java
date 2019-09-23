class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int num : nums) pq.offer( num );
        
        int count = nums.length - k;
        while(count > 0) {
            pq.poll();
            count--;
        }
        return pq.peek();
    }
}
