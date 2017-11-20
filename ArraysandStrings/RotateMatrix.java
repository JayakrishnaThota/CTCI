class Solution {
    public void rotate(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return;
        int row = matrix.length;
        int column = matrix[0].length;
        for(int i=0;i<row;i++){
            for(int j=i+1;j<column;j++){
               int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<column/2;j++){
               int temp = matrix[i][j];
                matrix[i][j] = matrix[i][column-j-1];
                matrix[i][column-1-j] = temp;
            }
        }
    }
}
