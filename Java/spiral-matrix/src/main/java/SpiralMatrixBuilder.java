public class SpiralMatrixBuilder{

    public static int[][] buildMatrixOfSize(int size)
    {
        int [][] retorno = new int[size][size];
        int startingRow = 0 , endingRow = size, startingColumn = 0 , endingColumn = size, iterator , count =1;

        while (startingRow < endingRow && startingColumn < endingColumn) {
            for (iterator = startingColumn ; iterator < endingColumn ; iterator++) {
                retorno[startingRow][iterator] = count;
                count++;
            }
            startingRow++;

            for (iterator = startingRow ; iterator < endingRow ; iterator++) {
                retorno[iterator][endingColumn - 1] = count;
                count++;
            }
            endingColumn--;

            if (startingRow < endingRow) {
                for (iterator = endingColumn - 1; iterator >= startingColumn ; iterator--) {
                    retorno[endingRow - 1][iterator] = count;
                    count++;
                }
                endingRow--;
            }

            if (startingColumn < endingColumn) {
                for (iterator = endingRow - 1; iterator >= startingRow ; iterator--) {
                    retorno[iterator][startingColumn] = count;
                    count++;
                }
                startingColumn++;
            }
        }
        return retorno;
    }

}
