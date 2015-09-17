import java.util.HashSet;

/*
 * Leetcode:
 * Determine if a Sudoku is valid, according to:
 * http://sudoku.com.au/TheRules.aspx
 * A valid Sudoku board (partially filled) is not necessarily solvable. 
 * Only the filled cells need to be validated.
 * */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int length = board.length;
        int subLength = length/3;
        
        int count = 0;
        HashSet<Character> hs;
        // check rows
        for (int i = 0; i < length; i++) {
            count = 0;
            hs = new HashSet<Character>();
            for (int j = 0; j < length; j++) {
                if (board[i][j] != '.') {
                    hs.add(board[i][j]);
                    count++;
                }
            }
            if (count != hs.size())
                return false;
        }
        // check columns
        for (int j = 0; j < length; j++) {
            count = 0;
            hs = new HashSet<Character>();
            for (int i = 0; i < length; i++) {
                if (board[i][j] != '.') {
                    hs.add(board[i][j]);
                    count++;
                }
            }
            if (count != hs.size())
                return false;
        }       
        // check squares
        for (int i = 0; i < length; i = i + subLength) {
            for (int j = 0; j < length; j = j + subLength) {
                count = 0;
                hs = new HashSet<Character>();
                for (int m = 0; m < subLength; m++) {
                    for (int n = 0; n < subLength; n++) {
                        if (board[i + m][j + n] != '.') {
                            hs.add(board[i + m][j + n]);
                            count++;
                        }
                    }
                    if (count != hs.size())
                        return false;
                }
            }
        }
        return true;
    }
}
