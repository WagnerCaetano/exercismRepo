
class ReverseString {
    String reverse(String inputString) {
        if (inputString == null || inputString.isEmpty())
            return "";
        String result="";
        char[] vetor = inputString.toCharArray();
        for (int i = vetor.length - 1; i >= 0; i--)
            result += vetor[i];
        return result;
    }
}