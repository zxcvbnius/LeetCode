class NumArray {
    
    class TreeNode {
        int val; // sum
        int start; // start position of array
        int end; // end position of array
        TreeNode left;
        TreeNode right;
        
        /**
         * build tree => O(n)
         * update node => O(n)
         * rangeQuery => O(n +k) k is the number of reported segement tree
         * 
         **/
        
        public TreeNode(int start, int end, int val, TreeNode left, TreeNode right) {
            this.start = start;
            this.end = end;
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    public TreeNode buildTree(int[] nums, int start, int end, int sum) {
        if(start == end) return new TreeNode(start, end, nums[start] + sum, null, null);
        
        int mid = (start + end) / 2;
        TreeNode left = buildTree(nums, start, mid, sum);
        TreeNode right = buildTree(nums, mid + 1 , end, sum);
        TreeNode root = new TreeNode(start, end, left.val + right.val, left, right);
        return root;
    }
    
    public void updateNode(TreeNode node, int updateIdx, int updateVal) {
        if(node.start == updateIdx && node.end == updateIdx) {
            node.val = updateVal;
            return;
        }

        int mid = (node.start + node.end) / 2;
        
        if(mid >= updateIdx) { // find left side
            updateNode( node.left, updateIdx, updateVal);
        } else {
            updateNode( node.right, updateIdx, updateVal);
        }
        
        node.val = node.left.val + node.right.val;
    }
    
    public int rangeQuery(TreeNode node, int start, int end) {
        if(node.start == start && node.end == end) {
            return node.val;
        }
        
        int mid = (node.start + node.end) / 2;
        
        if( end <= mid) {
            return rangeQuery( node.left, start, end);
        }
        
        if( start > mid ) {
            return rangeQuery( node.right, start, end);
        }
        
        return rangeQuery( node.left, start, mid) + rangeQuery( node.right, mid + 1, end );
    }
    
    TreeNode root = null;
    int[] nums = null;
    public NumArray(int[] nums) {
        this.nums = nums;
        if(this.nums == null || this.nums.length == 0) {
            this.root = null;
        } else {
            this.root = buildTree(nums, 0, nums.length - 1, 0);           
        }
    }
    
    public void update(int i, int val) {
        updateNode(this.root, i, val);
    }
    
    public int sumRange(int i, int j) {
        return rangeQuery(this.root, i, j);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
