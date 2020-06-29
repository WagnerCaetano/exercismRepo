import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Knapsack{
    private int limite;
    private List<Item> items;

    public int maximumValue(int limite, ArrayList<Item> items)
    {
        if(limite<0)
            throw new IllegalArgumentException("Argumentos fornecidos estao invalidos");
        this.limite = limite;
        this.items = items;
        int maxValues = 0;
        if(!items.isEmpty() ) {
            if (!overWeight(limite)){
                maxValues = findMostValueItems();
            }
        }

        return maxValues;
    }

    private int findMostValueItems()
    {
        Collections.sort(items);
        int valueMax = 0;
        int valueTemp = 0;
        int weightTemp = 0;
        for (int j = 0 , i = items.size()-1; j < items.size() && weightTemp<limite && i > 0; j++ , i--) {
            valueTemp+=items.get(i).getValue();
            weightTemp+=items.get(i).getWeight();
            if(weightTemp>limite)
            {
                valueTemp -= items.get(items.indexOf(Collections.max(items))).getValue();
                weightTemp -= items.get(items.indexOf(Collections.max(items))).getWeight();
                items.remove(Collections.max(items));
                if(valueTemp < valueMax)
            }
            valueMax = valueTemp;
        }
    }

    private boolean overWeight(int limite)
    {
        return(Collections.min(items).compareTo(new Item(limite,0))>0);

    }

}