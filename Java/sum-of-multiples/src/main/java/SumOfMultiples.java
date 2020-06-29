class SumOfMultiples {
    private int soma = 0;

    SumOfMultiples(int number, int[] set) {
        somador(number,set);
    }

    private void somador(int number , int[] set)
    {
        for(int contador = 0 ; contador <number ; contador++)
            for(int i = 0 ; i < set.length ; i++) {
                if (set[i] != 0)
                    if (contador % set[i] == 0) {
                        soma += contador;
                        break;
                    }
            }
    }

    int getSum() {
        return soma;
    }

}
