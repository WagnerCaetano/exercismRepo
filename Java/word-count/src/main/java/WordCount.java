import java.util.HashMap;
import java.util.Map;

public class WordCount {

    public Map<String,Integer> phrase(String phrase){
        Map<String,Integer> retorno = new HashMap<>();
        if (phrase.isEmpty() || phrase.trim().length() == 0) {
            return retorno;
        }
        if(!phrase.contains(" ") && !phrase.contains(",")) {
            retorno.put(phrase, 1);
        }
        else {
            phrase = phrase.toLowerCase();
            phrase = phrase.replaceAll("\n", "");
            phrase = phrase.replaceAll("[:!!&@$%^&.]", " ");
            String[] partes = null;
            if (phrase.contains(" ")) {
                phrase = phrase.replaceAll(",","");
                partes = phrase.split(" ");
            }
            else if (phrase.contains(",")) {
                partes = phrase.split(",");
            }
            for (int i = 0; i < partes.length; i++) {

                if (!partes[i].isEmpty()) {

                    if (!ehLetraOuNumero(partes[i].charAt(0))) {
                        StringBuilder nova = new StringBuilder();

                        for (int o = 1; o < partes[i].length()-1; o++) {
                            nova.append(partes[i].charAt(o));
                        }

                        partes[i] = nova.toString();
                    }

                    if (!retorno.containsKey(partes[i])) {
                        retorno.put(partes[i], 1);
                    }

                    else {
                        retorno.replace(partes[i], retorno.get(partes[i]) + 1);
                    }
                }
            }
        }
        return retorno;
    }

    public static boolean ehLetraOuNumero(char ch)
    {
        return new StringBuilder().append(ch).toString().matches("[a-zA-Z0-9]");
    }
}