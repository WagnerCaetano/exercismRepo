import java.util.HashMap;
import java.util.Map;

public class NucleotideCounter{

    private Map<Character,Integer> frequencies;

    public NucleotideCounter(String nucleotideStr){

        this.frequencies = new HashMap<>(){
            {
                put('A',0);
                put('C',0);
                put('G',0);
                put('T',0);
            }
        };

        for (char nucleotideo: nucleotideStr.toCharArray()) {
            if(this.frequencies.containsKey(nucleotideo))
            {
                this.frequencies.computeIfPresent(nucleotideo,(k, v) -> v + 1);
            }
            else{
                throw new IllegalArgumentException("Invalid DNA string");
            }
        }

    }

    public Map nucleotideCounts(){
        return this.frequencies;
    }

}
