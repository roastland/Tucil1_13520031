public class Operations {
    boolean checkEast(Matrix puzz, String word, int rowIdx, int colIdx, int comp) {
        int idx=0;
        while (colIdx < puzz.cols) {
            comp++;
            if (puzz.M[rowIdx][colIdx] == word.charAt(idx)) {
                idx++;
                if (idx == word.length())
                    return true;
                else
                    colIdx++;
            }
            else
                return false;
        }
        return false;
    }
    void printEast(Matrix puzz, String word, int rowIdx, int colIdx) {
        int m=puzz.rows, n=puzz.cols, l=word.length()-1;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if ((i == rowIdx) && (j >= colIdx) && (j <= colIdx+l))
                    System.out.print(puzz.M[i][j]);
                else
                    System.out.print("-");
                 
                if (j == n-1)
                    System.out.print("\n");
                else
                    System.out.print(" "); 
            }
        }
    }

    boolean checkSouthEast(Matrix puzz, String word, int rowIdx, int colIdx, int comp) {
        int idx=0;
        while ((rowIdx < puzz.rows) && (colIdx < puzz.cols)) {
            comp++;
            if (puzz.M[rowIdx][colIdx] == word.charAt(idx)) {
                idx++;
                if (idx == word.length())
                    return true;
                else {
                    rowIdx++;
                    colIdx++;
                }
            }
            else
                return false;
        }
        return false;
    }
    void printSouthEast(Matrix puzz, String word, int rowIdx, int colIdx) {
        int m=puzz.rows, n=puzz.cols, l=word.length()-1;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if ((i-j == rowIdx-colIdx) && (i >= rowIdx) && (i <= rowIdx+l) && (j >= colIdx) && (j <= colIdx+l))
                    System.out.print(puzz.M[i][j]);
                else
                    System.out.print("-");
                 
                if (j == n-1)
                    System.out.print("\n");
                else
                    System.out.print(" "); 
            }
        }
    }

    boolean checkSouth(Matrix puzz, String word, int rowIdx, int colIdx, int comp) {
        int idx=0;
        while (rowIdx < puzz.rows) {
            comp++;
            if (puzz.M[rowIdx][colIdx] == word.charAt(idx)) {
                idx++;
                if (idx == word.length())
                    return true;
                else
                    rowIdx++;
            }
            else
                return false;
        }
        return false;
    }
    void printSouth(Matrix puzz, String word, int rowIdx, int colIdx) {
        int m=puzz.rows, n=puzz.cols, l=word.length()-1;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if ((j == colIdx) && (i >= rowIdx) && (i <= rowIdx+l))
                    System.out.print(puzz.M[i][j]);
                else
                    System.out.print("-");
                 
                if (j == n-1)
                    System.out.print("\n");
                else
                    System.out.print(" "); 
            }
        }
    }

    boolean checkSouthWest(Matrix puzz, String word, int rowIdx, int colIdx, int comp) {
        int idx=0;
        while ((rowIdx < puzz.rows) && (colIdx >= 0)) {
            comp++;
            if (puzz.M[rowIdx][colIdx] == word.charAt(idx)) {
                idx++;
                if (idx == word.length())
                    return true;
                else {
                    rowIdx++;
                    colIdx--;
                }
            }
            else
                return false;
        }
        return false;
    }
    void printSouthWest(Matrix puzz, String word, int rowIdx, int colIdx) {
        int m=puzz.rows, n=puzz.cols, l=word.length()-1;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if ((i+j == rowIdx+colIdx) && (i >= rowIdx) && (i <= rowIdx+l) && (j >= colIdx-l) && (j <= colIdx))
                    System.out.print(puzz.M[i][j]);
                else
                    System.out.print("-");
                 
                if (j == n-1)
                    System.out.print("\n");
                else
                    System.out.print(" "); 
            }
        }
    }

    boolean checkWest(Matrix puzz, String word, int rowIdx, int colIdx, int comp) {
        int idx=0;
        while (colIdx >= 0) {
            comp++;
            if (puzz.M[rowIdx][colIdx] == word.charAt(idx)) {
                idx++;
                if (idx == word.length())
                    return true;
                else
                    colIdx--;
            }
            else
                return false;
        }
        return false;
    }
    void printWest(Matrix puzz, String word, int rowIdx, int colIdx) {
        int m=puzz.rows, n=puzz.cols, l=word.length()-1;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if ((i == rowIdx) && (j >= colIdx-l) && (j <= colIdx))
                    System.out.print(puzz.M[i][j]);
                else
                    System.out.print("-");
                 
                if (j == n-1)
                    System.out.print("\n");
                else
                    System.out.print(" "); 
            }
        }
    }

    boolean checkNorthWest(Matrix puzz, String word, int rowIdx, int colIdx, int comp) {
        int idx=0;
        while ((rowIdx >= 0) && (colIdx >= 0)) {
            comp++;
            if (puzz.M[rowIdx][colIdx] == word.charAt(idx)) {
                idx++;
                if (idx == word.length())
                    return true;
                else {
                    rowIdx--;
                    colIdx--;
                }
            }
            else
                return false;
        }
        return false;
    }
    void printNorthWest(Matrix puzz, String word, int rowIdx, int colIdx) {
        int m=puzz.rows, n=puzz.cols, l=word.length()-1;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if ((i-j == rowIdx-colIdx) && (i >= rowIdx-l) && (i <= rowIdx) && (j >= colIdx-l) && (j <= colIdx))
                    System.out.print(puzz.M[i][j]);
                else
                    System.out.print("-");
                 
                if (j == n-1)
                    System.out.print("\n");
                else
                    System.out.print(" "); 
            }
        }
    }

    boolean checkNorth(Matrix puzz, String word, int rowIdx, int colIdx, int comp) {
        int idx=0;
        while (rowIdx >= 0) {
            comp++;
            if (puzz.M[rowIdx][colIdx] == word.charAt(idx)) {
                idx++;
                if (idx == word.length())
                    return true;
                else
                    rowIdx--;
            }
            else
                return false;
        }
        return false;
    }
    void printNorth(Matrix puzz, String word, int rowIdx, int colIdx) {
        int m=puzz.rows, n=puzz.cols, l=word.length()-1;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if ((j == colIdx) && (i >= rowIdx-l) && (i <= rowIdx))
                    System.out.print(puzz.M[i][j]);
                else
                    System.out.print("-");
                 
                if (j == n-1)
                    System.out.print("\n");
                else
                    System.out.print(" "); 
            }
        }
    }

    boolean checkNorthEast(Matrix puzz, String word, int rowIdx, int colIdx, int comp) {
        int idx=0;
        while ((rowIdx >= 0) && (colIdx < puzz.cols)) {
            comp++;
            if (puzz.M[rowIdx][colIdx] == word.charAt(idx)) {
                idx++;
                if (idx == word.length())
                    return true;
                else {
                    rowIdx--;
                    colIdx++;
                }
            }
            else
                return false;
        }
        return false;
    }
    void printNorthEast(Matrix puzz, String word, int rowIdx, int colIdx) {
        int m=puzz.rows, n=puzz.cols, l=word.length()-1;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if ((i+j == rowIdx+colIdx) && (i >= rowIdx-l) && (i <= rowIdx) && (j >= colIdx) && (j <= colIdx+l))
                    System.out.print(puzz.M[i][j]);
                else
                    System.out.print("-");
                 
                if (j == n-1)
                    System.out.print("\n");
                else
                    System.out.print(" "); 
            }
        }
    }
}
