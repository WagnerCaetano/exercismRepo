import java.util.ArrayList;
import java.util.List;

public class Flattener{
    private List retorno;

    public Flattener(){
        retorno = new ArrayList<>();
    }

    public List flatten(List lista){

        for (Object object : lista) {
            if(object != null) {
                if (object.getClass() == Character.class || object.getClass() == String.class || object.getClass() == Integer.class) {
                    retorno.add(object);
                } else {
                    flatten((List) object);
                }
            }
        }
        return retorno;

    }

}