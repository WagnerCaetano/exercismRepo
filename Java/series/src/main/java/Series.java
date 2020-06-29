import java.util.ArrayList;
import java.util.List;

public class Series {

    private String setence;

    public Series (String setence)
    {
        this.setence = setence;
    }

    public List<String> slices(int pieces)
    {
        if(pieces<=0)
            throw new IllegalArgumentException("Slice size is too small.");
        if(pieces>=6 || setence.length() == 0 || setence.isEmpty())
            throw new IllegalArgumentException("Slice size is too big.");
        List<String> retorno = new ArrayList<>();
        for (int i = 0; i <= setence.length()-pieces; i++) {
            retorno.add(setence.substring(i,i+pieces));
        }
        return retorno;
    }

}
