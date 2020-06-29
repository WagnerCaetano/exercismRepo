class Twofer {
    String twofer(String name) {
        String retorno = (name == null || name.length() == 0 )?"One for you, one for me.":"One for "+name+", one for me.";
        return retorno;
    }
}
