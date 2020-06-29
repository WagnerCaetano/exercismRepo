public class PascalsTriangleGenerator{

    public int[][] generateTriangle(int row){
        int[][] retorno = new int[row][];
        if(row == 1)
        {
            retorno[0] = new int[1];
            retorno[0][0] = 1;
        }
        else if(row > 1)
        {
            for (int i = 0; i < row; i++) {
                retorno[i]= new int[i+1];
                retorno[i][0]=1;
                retorno[i][retorno[i].length-1] = 1;
                for (int j = 1; j < i; j++) {
                    retorno[i][j] = retorno[i-1][j-1]+retorno[i-1][j];
                }
            }
        }
        return retorno;
    }
}