class RnaTranscription {

    String transcribe(String dnaStrand){
        if(dnaStrand==null || dnaStrand.isEmpty())
            return "";
        if(dnaStrand.length()==1)
            switch(dnaStrand)
            {
                case "G":
                    return "C";
                case "C":
                    return "G";
                case "T":
                    return "A";
                case "A":
                    return "U";
                default:
                    return "";
            }
        else {
            StringBuilder resultado = new StringBuilder();
            for (int i = 0; i < dnaStrand.length(); i++) {
                resultado.append(transcribe(dnaStrand.charAt(i)+""));
            }
            return resultado.toString();
        }
    }

}
