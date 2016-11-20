/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
 
 // Sol0, StringBuffer has more effectively than char array
 public String convert(String s, int nRows) {
    char[] c = s.toCharArray();
    int len = c.length;
    StringBuffer[] sb = new StringBuffer[nRows];
    for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();
    
    int i = 0;
    while (i < len) {
        for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
            sb[idx].append(c[i++]);
        for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
            sb[idx].append(c[i++]);
    }
    for (int idx = 1; idx < sb.length; idx++)
        sb[0].append(sb[idx]);
    return sb[0].toString();
}
 
 // Sol1
 public class Solution {
    public String convert(String s, int numRows) {
        
        if(numRows == 1) return s;
        
        char[] chars = s.toCharArray();
        int len      = chars.length; 
        char[][] res = new char[numRows][len / (numRows*2 - 2) * (numRows - 1) + (numRows*2 - 2) ];
        int[] rIndex = new int[numRows];
        
        int index = 0;
        while(index < len) {
            // vertical down
            for(int i = 0 ; i < numRows && index < len; i++) {
                res[i][ rIndex[i] ] = chars[index];
                index++;
                rIndex[i]++;
            }
            // obliquely up
            for(int i = numRows - 2 ; i > 0 && index < len; i--) {
                res[i][ rIndex[i] ] = chars[index];
                index++;
                rIndex[i]++;
            }
        }
        
        index = 0;
        for(int i = 0 ; i < numRows; i++) {
            for(int j = 0 ; j < rIndex[i]; j++)
            chars[index++] = res[i][j];
        }
        return new String(chars);
    }
}
 
 // Sol2(Bad), Result. "Your runtime beats 3.82% of java submissions"
 public class Solution {
    public String convert(String s, int numRows) {
        
        char[] chars = s.toCharArray();
        int len = chars.length;
        
        if(numRows == 1) return s;
        else if(numRows == 2) {
            String res = "";
            {
                char[] temp = new char[len / 2 + (len % 2 == 1 ? 1 : 0) ];
                int index   = 0;
                for(int i = 0 ; i < len ; i += 2) {
                    temp[index] = chars[i];
                    index++;
                }
                res = new String(temp);
            } {
                char[] temp = new char[len / 2];
                int index   = 0;
                for(int i = 1 ; i < len ; i += 2) {
                    temp[index] = chars[i];
                    index++;
                }
                res = res + new String(temp);
            }
            return res;            
        } else {
            int counts = (numRows - 1) * 2; // creating a "z" needs "counts" of characters
            int row    = (len / counts)*(numRows - 1) + counts;
            int col    = numRows;
            char[][] res = new char[row][col];
            {
                int index = 0;
                int zIndex = 0; 
                for(int i = 0 ; i < row && index < len ; i++) {
                    for(int j = zIndex ; j < col && index < len; j++) {
                        res[i][j] = chars[index];
                        index++;
                        if(zIndex != 0) break;
                    }
                    if(zIndex == 0) zIndex = col - 2;
                    else zIndex--;
                }
                /*for(int i = 0 ; i < row; i++) {
                    for(int j = 0 ; j < col ; j++) {
                        System.out.print(" " + ((res[i][j] != '\u0000') ? res[i][j] : " ") );
                    }
                    System.out.println("");
                }*/
            } {
                int index = 0;
                for(int i = 0 ; i < col ; i++) {
                    for(int j = 0 ; j < row ; j++) {
                        if(res[j][i] != '\u0000' ) {
                            chars[index] = res[j][i];
                            index++;
                        }
                    }
                }
            }
            return new String(chars);
        }
    }
}
