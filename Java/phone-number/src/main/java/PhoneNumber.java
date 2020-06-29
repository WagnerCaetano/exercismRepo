public class PhoneNumber{
    private static String wrongLengthExceptionMessage = "incorrect number of digits";
    private static String moreThan11DigitsExceptionMessage = "more than 11 digits";
    private static String numberIs11DigitsButDoesNotStartWith1ExceptionMessage =
            "11 digits must start with 1";
    private static String illegalCharacterExceptionMessage =
            "letters not permitted";
    private static String illegalPunctuationExceptionMessage =
            "punctuations not permitted";
    private static String areaCodeStartsWithZeroExceptionMessage =
            "area code cannot start with zero";
    private static String areaCodeStartsWithOneExceptionMessage =
            "area code cannot start with one";
    private static String exchangeCodeStartsWithZeroExceptionMessage =
            "exchange code cannot start with zero";
    private static String exchangeCodeStartsWithOneExceptionMessage =
            "exchange code cannot start with one";

    private String phoneNumber;

    public PhoneNumber(String phoneNumber){
        this.phoneNumber = verificaNumero(phoneNumber);
    }

    public String getNumber(){
        return this.phoneNumber;
    }

    public static String ajustarNumero(String phoneNumber){
        return phoneNumber.replaceAll("[^0-9]","");
    }

    public static String tirarCodigoDoPais(String phoneNumber){
        return phoneNumber.substring(1);
    }

    public static String verificaNumero(String phoneNumber){
        for (int i = 0; i < phoneNumber.length(); i++) {
            if(ehLetra(phoneNumber.charAt(i))){
                throw new IllegalArgumentException(illegalCharacterExceptionMessage);
            }
        }
        for (int i = 0; i < phoneNumber.length(); i++) {
            if(ehPontuacao(phoneNumber.charAt(i))){
                throw new IllegalArgumentException(illegalPunctuationExceptionMessage);
            }
        }
        phoneNumber = ajustarNumero(phoneNumber);
        if(phoneNumber.length()<10 ) {
            throw new IllegalArgumentException(wrongLengthExceptionMessage);
        }
        if(phoneNumber.length()>11) {
            throw new IllegalArgumentException(moreThan11DigitsExceptionMessage);
        }
        if(phoneNumber.length() == 11 && phoneNumber.charAt(0)!='1') {
            throw new IllegalArgumentException(numberIs11DigitsButDoesNotStartWith1ExceptionMessage);
        }
        if(phoneNumber.charAt(0) == '1' && phoneNumber.length() == 11) {
            phoneNumber = tirarCodigoDoPais(phoneNumber);
        }
        if(phoneNumber.charAt(0) == '1') {
            throw new IllegalArgumentException(areaCodeStartsWithOneExceptionMessage);
        }
        if(phoneNumber.charAt(0) == '0'){
            throw new IllegalArgumentException(areaCodeStartsWithZeroExceptionMessage);
        }
        if(phoneNumber.charAt(3) == '1') {
            throw new IllegalArgumentException(exchangeCodeStartsWithOneExceptionMessage);
        }
        if(phoneNumber.charAt(3) == '0'){
            throw new IllegalArgumentException(exchangeCodeStartsWithZeroExceptionMessage);
        }

        return phoneNumber;
    }


    public static boolean ehLetra(char ch)
    {
        return new StringBuilder().append(ch).toString().matches("[a-zA-Z]");
    }

    public static boolean ehPontuacao(char ch)
    {
        return new StringBuilder().append(ch).toString().matches("[@:!]");
    }

}