import java.util.Objects;

public class Item implements Comparable{

    private int weight;
    private int value;

    Item(int weight , int value)
    {
        if( weight<=0 || value <0)
            throw new IllegalArgumentException("Item needs to have a positive weight");
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return weight == item.weight &&
                value == item.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, value);
    }

    @Override
    public String toString() {
        return "Item has a "+this.value+" value and "+this.weight+" pounds";
    }


    @Override
    public int compareTo(Object o) {
        if(o == null)
            throw new IllegalCallerException("Object to compare is null");
        if(o.getClass() != Item.class)
            throw new IllegalCallerException("Cannot compare differents classes.");
        Item outro = (Item) o;
        if(this.weight > outro.weight && this.value > outro.value)
            return 1;
        else if(this.weight < outro.weight && this.value < outro.weight)
            return -1;
        return 0;
    }
}
