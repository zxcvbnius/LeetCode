class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<>();

        if(numRows == 0) return result;
        
        List<Integer> firstLine = new LinkedList<>();
        firstLine.add(1);
        result.add(firstLine);
        
        List<Integer> curLine = firstLine;
        
        for(int i = 1 ; i < numRows ; i++) {
            List<Integer> nextLine = generateNextLine(curLine);
            curLine = nextLine;
            result.add(nextLine);
        }
        
        return result;
    }
    
    public List<Integer> generateNextLine(List<Integer> line) {
        List<Integer> nextLine = new LinkedList<>();
        
        nextLine.add(1); // head
        for(int i = 0 ; i < line.size() - 1 ; i++) {
            nextLine.add( line.get(i) + line.get(i+1) );
        }
        
        nextLine.add(1); // end
        
        return nextLine;
    }
}
