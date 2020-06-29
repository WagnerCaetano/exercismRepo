import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ProteinTranslator {

    List<String> translate(String rnaSequence) {
        List<String> lista = new ArrayList<>();
        if(rnaSequence == null || rnaSequence.isEmpty())
            return lista;
        for(int i = 0 ; i < rnaSequence.length() ; i+=3)
        {
            String codon = new StringBuilder().append(rnaSequence.charAt(i)).append(rnaSequence.charAt(i+1)).append(rnaSequence.charAt(i+2)).toString();
            if(codon.equals("AUG"))
                lista.add("Methionine");
            if(codon.equals("UUU") || codon.equals("UUC"))
                lista.add("Phenylalanine");
            if(codon.equals("UUA") || codon.equals("UUG"))
                lista.add("Leucine");
            if(codon.equals("UCU") || codon.equals("UCC") || codon.equals("UCA") || codon.equals("UCG"))
                lista.add("Serine");
            if(codon.equals("UAU") || codon.equals("UAC"))
                lista.add("Tyrosine");
            if(codon.equals("UGU") || codon.equals("UGC"))
                lista.add("Cysteine");
            if(codon.equals("UGG"))
                lista.add("Tryptophan");
            if(codon.equals("UAA") || codon.equals("UAG") || codon.equals("UGA"))
                break;
        }
        return lista;
    }
}