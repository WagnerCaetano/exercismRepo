import java.util.List;

public class BinarySearch{

    private List<Integer> list;
    private static final String VALUE_NOT_FOUND = "Value not in array";

    public BinarySearch(List list){
        this.list = list;
    }

    public int indexOf(int value) throws ValueNotFoundException {
        if(list.isEmpty()){
            throw new ValueNotFoundException(VALUE_NOT_FOUND);
        }
        if(value > list.get(list.size()-1)) {
            throw new ValueNotFoundException(VALUE_NOT_FOUND);
        }
        if(value < list.get(0)) {
            throw new ValueNotFoundException(VALUE_NOT_FOUND);
        }

        int start = 0;
        int end = list.size();
        int i = 0;
        boolean found = false;

        while(start <= end) {
            i = (start + end)/2;

            if( list.get(i) < value) {
                start = i + 1;
            }

            else if( list.get(i) > value ) {
                end = i - 1;
            }

            else if (list.get(i) == value) {
                found = true;
                break;
            }
        }

        if(!found){
            throw new ValueNotFoundException(VALUE_NOT_FOUND);
        }
        return i;
    }

}