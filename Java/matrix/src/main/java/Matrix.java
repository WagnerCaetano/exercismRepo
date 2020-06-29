import java.util.ArrayList;
import java.util.List;

class Matrix {
    private int[][] matrixDeRetorno;

    Matrix(String matrixAsString) {
        matrixDeRetorno = new int[10][10];
        construirMatriz(matrixAsString);
    }
    private void construirMatriz(String matrixAsString)
    {
        String[] linhas = matrixAsString.split("\n");
        String[] colunasPorLinhas = null;
        for (int i = 0; i < linhas.length; i++) {
            colunasPorLinhas = linhas[i].split(" ");
            for (int j = 0; j < colunasPorLinhas.length; j++) {
                 matrixDeRetorno[i][j] = Integer.parseInt(colunasPorLinhas[j]);
            }
        }
    }

    int[] getRow(int rowNumber) {
        List<Integer> array = new ArrayList();
        for (int i = 0; i < matrixDeRetorno.length; i++) {
            if(matrixDeRetorno[rowNumber-1][i]!=0)
                array.add(matrixDeRetorno[rowNumber-1][i]);
        }
        int[] retorno = new int[array.size()];
        for (int i = 0; i < retorno.length; i++) {
            retorno[i] = array.get(i);
        }
        return retorno;
    }

    int[] getColumn(int columnNumber) {
        List<Integer> array = new ArrayList();
        for (int i = 0; i < matrixDeRetorno.length; i++) {
            if(matrixDeRetorno[i][columnNumber-1]!=0)
                array.add(matrixDeRetorno[i][columnNumber-1]);
        }
        int[] retorno = new int[array.size()];
        for (int i = 0; i < retorno.length; i++) {
            retorno[i] = array.get(i);
        }
        return retorno;
    }
}