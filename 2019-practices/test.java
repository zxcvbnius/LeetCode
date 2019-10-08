  int lo = 0, hi = 0;
      for(int n : nums) {
        lo = Math.max(lo, n);
        hi += n;
      }

      while( lo < hi ) {
        int mid = (hi - lo) / 2 + lo;
        int count = 0, g = 0;
        for(int n : nums) {
          count += n;
          if( count > mid) {
            g++;
            count = n;
          }
        }
        if( g > m ) {
          hi = mid - 1;
        } else if (g < m) {
          lo = mid + 1;
        }
      }
      return lo;
