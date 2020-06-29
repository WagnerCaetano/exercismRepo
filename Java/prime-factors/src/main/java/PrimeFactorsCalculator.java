import java.util.ArrayList;
import java.util.List;

public class PrimeFactorsCalculator{

    public List calculatePrimeFactorsOf(long l)
    {
        List retorno = new ArrayList<Long>();
        long divisor = 2L;
        long numero = l;

        while (divisor <= numero)
        {
            if(numero % divisor == 0){
                retorno.add(divisor);
                numero = numero/divisor;
            }
            else{
                divisor++;
            }

            if(divisor == l && retorno.isEmpty()) {
                retorno.add(l);
            }
        }
        return retorno;
    }

}
