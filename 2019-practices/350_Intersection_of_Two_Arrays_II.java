class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // no consider nums1 is null or nums2 is null cases
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        if(len1 == 0 || len2 == 0) return new int[0];
        
        quicksort(nums1, 0 , len1 -1);
        quicksort(nums2, 0 , len2 -1);

        int curIndex1 = 0;
        int curIndex2 = 0;

        LinkedList<Integer> result = new LinkedList<>();

        while( curIndex1 < len1 && curIndex2 < len2 ) {
            int val1 = nums1[ curIndex1 ];
            int val2 = nums2[ curIndex2 ];

            if( val1 == val2 ) {
                result.add(val1);
                curIndex1++;
                curIndex2++;
            } else if ( val1 > val2 ) {
                curIndex2++;
            } else if (val1 < val2) {
                curIndex1++;
            }
        }

        int[] resultArray = new int[ result.size() ];
        for(int i = 0 ; i < result.size() ; i++ ) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }

    public void quicksort(int[] nums, int start, int end) {
        int i = start, j = end, pivot = nums[ (start + end) / 2  ];
        while( i <= j) {
            while( pivot > nums[i] ) i++;
            while( pivot < nums[j] ) j--;

            if(i <= j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }

        if( start < j ) quicksort(nums, start, j);
        if( i < end ) quicksort(nums, i , end);
    }
}
