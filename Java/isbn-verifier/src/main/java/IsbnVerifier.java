class IsbnVerifier {

    public static boolean isValid(String stringToVerify) {
        stringToVerify = stringToVerify.replaceAll("-","");
        int sum = 0, maxValid = stringToVerify.length() , minValid = 10;

        if(stringToVerify.length()<minValid || stringToVerify.length() >minValid) {
            return false;
        }

        for (int stringIndex = 0; stringIndex < stringToVerify.length(); stringIndex++) {
            char number = stringToVerify.charAt(stringIndex);

            if(number == 'X' && stringIndex == stringToVerify.length()-1){
                stringToVerify.replace('X',Character.MIN_VALUE);
                sum += maxValid * (maxValid-stringIndex);
            }

            else {
                try {
                    sum += Integer.parseInt(new StringBuilder().append(number).toString()) * (maxValid - stringIndex);
                }
                catch (NumberFormatException ex)
                {
                    return false;
                }
            }

        }

        return(sum % 11 == 0);
    }

}
