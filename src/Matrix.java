public class Matrix {
    char[][] M;
    int rows=0, cols=0;

    public Matrix(int rows, int cols) {
        M = new char[rows][cols];
        this.rows = rows;
        this.cols =cols;
    }

    public Matrix(char[][] M){
        rows=M.length;
        cols=M[0].length;
        this.M =new char[rows][cols];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                this.M[i][j]= M[i][j];
            }
        }
    }
}
