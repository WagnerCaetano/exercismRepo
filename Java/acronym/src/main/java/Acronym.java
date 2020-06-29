class Acronym {
    private StringBuilder retorno = new StringBuilder();

    Acronym(String phrase) {
        retorno.append(phrase.charAt(0));
        for(int x = 0 ; x<phrase.length() ;x++) {
            if ( (phrase.charAt(x) == ' ' || phrase.charAt(x) == '-' || phrase.charAt(x) == '_') &&
                    (phrase.charAt(x + 1) != ' ' && phrase.charAt(x + 1) != '-' && phrase.charAt(x + 1) != '_') ) {
                retorno.append(phrase.charAt(x + 1));
            }
        }
    }

    String get() {
        return retorno.toString().toUpperCase();
    }

}
