
class PrimeCalculator {

    int nth(int nth) {
        if(nth<=0) {
            throw new IllegalArgumentException("The nth number needs to be positive");
        }
        int count = 0;
        for (int i = 2; true ; i++) {
            if(ehPrimo(i)){
                count++;
                if(count == nth)
                    return i;
            }
        }
    }

    public static boolean ehPrimo(int numero)
    {
        for (int j = 2; j < numero; j++) {
            if (numero % j == 0)
                return false;
        }
        return true;
    }
}
