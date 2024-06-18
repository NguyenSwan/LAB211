public class Matrix {
    private int rows;
    private int cols;
    private int [][]data;

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }
    public Matrix add(Matrix other) throws Exception{
        if(rows != other.rows|| cols !=other.cols){
            throw new Exception("Rows and cols two matrix must be same");
        }
        Matrix result = new Matrix();
        int dataResult[][] = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dataResult[i][j]=this.data[i][j]+other.data[i][j];
            }
        }
        result.setRows(rows);
        result.setCols(cols);
        result.setData(dataResult);
        return result;
    }

    public Matrix subtract(Matrix other) throws Exception{
        if(rows != other.rows|| cols !=other.cols){
            throw new Exception("Rows and cols two matrix must be same");
        }
        Matrix result = new Matrix();
        int dataResult[][] = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dataResult[i][j]=this.data[i][j]-other.data[i][j];
            }
        }
        result.setRows(rows);
        result.setCols(cols);
        result.setData(dataResult);
        return result;
    }

    public Matrix multiply(Matrix other) throws Exception{
        if(cols != other.rows){
            throw new Exception("Cols of matrix 1 must be equal rows of matrix 2");
        }
        Matrix result = new Matrix();
        int dataResult[][] = new int[rows][other.cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                for (int k = 0; k < cols; k++) {
                    dataResult[i][j] += this.data[i][k]*other.data[k][j];
                }
            }
        }
        result.setRows(rows);
        result.setCols(other.cols);
        result.setData(dataResult);
        return result;
    }

    public String toString(){
        String str="";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                str+=String.format("[%d]", data[i][j]);
            }
            str+="\n";
        }
        return str;
    }

    Validation validation = new Validation();
    public Matrix input(String messInfor,int row, int col) {
        setRows(row);
        setCols(col);
        int data[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                data[i][j] = validation.checkInputInt(messInfor+String.format("[%d][%d]: ", i + 1, j + 1),
                        "Invalid!", Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }
        setData(data);
        return this;
    }
}
