class Solution {
    public int minSwap(int[] A, int[] B) {
        int len = A.length;
        int[] keep = new int[ len ];
        int[] swap = new int[ len ];

        swap[0] = 1;

        for(int i = 1 ; i < len ; i++) {

            keep[i] = len;
            swap[i] = len;

            if( A[i - 1] < A[i] && B[i - 1] < B[i]) {
                keep[i] = keep[ i - 1 ];
                swap[i] = swap[ i - 1 ] + 1;
            }

            if( A[i - 1] < B[i] && B[i - 1] < A[i] ) {
                keep[i] = Math.min( keep[i], swap[i-1] );
                swap[i] = Math.min( swap[i], keep[i - 1] + 1 );
            }
        }

        return Math.min( keep[ len - 1 ], swap[ len - 1 ]  );
    }
}
