import java.util.ArrayList;
import java.util.List;


public class NQueens {

	public static void main(String[] args) {
		List<List<String>> list = solveNQueens(4);
		System.out.println(list.size());

	}

    public static List<List<String>> solveNQueens(int n) {
        char[][] cArray = new char[n][n];
        int[][] unavailable = new int[n][n];
        int layer = 0;
        
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		cArray[i][j] = '.';
        	}
        }
        
        List<List<String>> result = new ArrayList<List<String>>();
        
        if (n == 0) return result;
        if (n == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add("Q");
            result.add(list);
            return result;
        }
        
        
        ArrayList<String> possibleResult = new ArrayList<String>();
        choose(layer, cArray, unavailable, result, possibleResult);
        return result;
    }
    
    public static void choose(int _layer, char[][] _cArray, int[][] _unavailable, List<List<String>> result, ArrayList<String> _possibleResult) {
        int layer = _layer + 1;
        int length = _unavailable.length;
        for (int i = 0; i < length; i++) {
            if (_unavailable[_layer][i] == 1) continue; 
            else {
            	
            	
                //int[][] unavailable = (int[][])_unavailable.clone();
                //char[][] cArray = (char[][])_cArray.clone();
            	int[][] unavailable = new int[length][length];
            	char[][] cArray = new char[length][length];
            	for (int m = 0; m < length; m++) {
            		for (int n = 0; n < length; n++) {
            			unavailable[m][n] = _unavailable[m][n];
            			cArray[m][n] = _cArray[m][n];
            		}
            	}
            	
            	
            	
            	
                setUnavailable(_layer, i, cArray, unavailable);
                ArrayList<String> possibleResult = (ArrayList<String>)_possibleResult.clone();
                possibleResult.add(new String(cArray[_layer]));
                
                if (layer == length) result.add(possibleResult);
                else choose(layer, cArray, unavailable, result, possibleResult);
            }
        }
    }
    
    public static void setUnavailable(int i, int j, char[][] _cArray, int[][] _unavailable) {
        _cArray[i][j] = 'Q';
        int length = _unavailable.length;
        for (int m = i; m < length; m++) {
            for (int n = 0; n < length; n++) {
                if (m == i) _unavailable[m][n] = 1;
                else if (n == j) _unavailable[m][n] = 1;
                else if (Math.abs(m - i) == Math.abs(n - j)) {
                    _unavailable[m][n] = 1;
                }
            }
        }
        
        for (int x = 0; x < length; x++) {
        	System.out.println();
        	for (int y = 0; y < length; y++) {
        		System.out.print(_unavailable[x][y]);
        	}
        }
    }
}
