public class Matrix {
    double[][] M;
    int rows=0, cols=0;

    public Matrix(int rows, int cols) {
        M = new double[rows][cols];
        this.rows = rows;
        this.cols =cols;
    }

    public Matrix(double[][] M){
        rows=M.length;
        cols=M[0].length;
        this.M =new double[rows][cols];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                this.M[i][j]= M[i][j];
            }
        }
    }
}
