import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Matrix {
    private Set<MatrixCoordinate> saddles;
    private int quantidadeDeLinhas;
    private int quantidadeDeColunas;

    Matrix(List<List<Integer>> values) {
        saddles = new HashSet<>();
        if(values.isEmpty()) {
            quantidadeDeLinhas = values.size();
            quantidadeDeColunas = values.get(0).size();
            percorrerLista(values);
        }
    }

    private void percorrerLista(List<List<Integer>> values)
    {
        for (int i = 0; i < quantidadeDeLinhas; i++) {
            for (int j = 0; j < quantidadeDeColunas; j++) {
                int value = values.get(i).get(j);
                buscadorDeSaddle(i,j,value,values);
            }
        }
    }

    public void buscadorDeSaddle (int indiceLinha,int indiceColuna , int value , List<List<Integer>> values)
    {
        boolean saddleColuna = false;
        boolean saddleLinha = false;
        int menor = value;

        for (int k = 0; k < quantidadeDeColunas; k++) {
            if( values.get(indiceLinha).get(k) > menor)
                menor = values.get(indiceLinha).get(k);
        }
        if(menor == value)
            saddleColuna = true;
        int maior = value;

        for (int k = 0; k < quantidadeDeLinhas; k++) {
            if(values.get(k).get(indiceColuna) < maior)
                maior = values.get(k).get(indiceColuna);
        }
        if(maior == value)
            saddleLinha = true;

        if(saddleColuna && saddleLinha)
            saddles.add(new MatrixCoordinate(indiceLinha+1,indiceColuna+1));
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        return saddles;
    }
}
