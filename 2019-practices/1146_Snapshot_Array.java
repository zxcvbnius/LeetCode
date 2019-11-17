class SnapshotArray {

    int length, snapCount;
    List<HashMap<Integer, Integer>> snapshots;

    public SnapshotArray(int length) {
        this.length = length + 1;
        this.snapshots = new ArrayList<>();
        this.snapCount = 0;
        
        this.snapshots.add( new HashMap<Integer, Integer>() );
    }
    
    public void set(int index, int val) {
        this.snapshots.get( this.snapCount ).put(index, val );
    }
    
    public int snap() {
        this.snapCount++;
        this.snapshots.add( new HashMap<Integer, Integer>() );
        
        return this.snapCount - 1;
    }
    
    public int get(int index, int snap_id) {
        int size = this.snapshots.size();
        if( snap_id > size ) return 0;
        
        for(int i = snap_id ; i >= 0 ; i--) {
            if( snapshots.get(i).containsKey(index) ) {
                return snapshots.get(i).get(index);
            }
        }
        
        return 0;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
