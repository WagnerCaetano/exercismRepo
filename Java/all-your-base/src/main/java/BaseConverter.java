import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseConverter{

    private int base;
    private int[] numero;

    public BaseConverter(int base,int[] numero)
    {
        if(base<2)
            throw new IllegalArgumentException("Bases must be at least 2.");
        for (int i = 0; i < numero.length; i++) {
            if(numero[i] < 0) {
                throw new IllegalArgumentException("Digits may not be negative.");
            }
            if(numero[i] >= base) {
                throw new IllegalArgumentException("All digits must be strictly less than the base.");
            }
        }
        this.base = base;
        this.numero = numero;
    }

    public int[] convertToBase(int fator)
    {
        if(fator<2)
            throw new IllegalArgumentException("Bases must be at least 2.");
        int base10 = convertToBase10();
        if(fator!=10) {
            List ordem = new ArrayList<Integer>();
            while(base10 >= fator) {
                ordem.add((base10 % fator));
                base10 = base10 / fator;
            }
            ordem.add(base10);
            Collections.reverse(ordem);
            int[] retorno = new int[ordem.size()];
            for (int j = 0; j < retorno.length; j++) {
                retorno[j] = (int)ordem.get(j);
            }
            return retorno;
        }
        else{
            int[] retorno = new int [(base10+"").length()];
            for (int i = 0; i < retorno.length; i++) {
                retorno[i] = Integer.parseInt((base10+"").charAt(i)+"");
            }
            return retorno;
        }

    }

    private int convertToBase10()
    {
        int base10 = 0;
        for (int i = this.numero.length-1 , j = 0; i >= 0 && j<this.numero.length; i-- , j++) {
            base10 += numero[j]*Math.pow(base,i);
        }
        return base10;
    }
}