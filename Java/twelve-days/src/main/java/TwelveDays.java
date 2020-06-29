class TwelveDays {
    String verse(int verseNumber) {
        if (verseNumber<=0 || verseNumber>=13)
            return "";
        String[] day = {"first","second","third","fourth","fifth","sixth","seventh","eighth","ninth","tenth","eleventh","twelfth"};
        String[] messages = {"a Partridge in a Pear Tree.","two Turtle Doves, and ","three French Hens, ","four Calling Birds, " ,
                "five Gold Rings, ","six Geese-a-Laying, ","seven Swans-a-Swimming, ","eight Maids-a-Milking, ","nine Ladies Dancing, ",
                "ten Lords-a-Leaping, ","eleven Pipers Piping, ","twelve Drummers Drumming, "};
        String setence = new StringBuilder().append("On the ").append(day[verseNumber-1])
                    .append(" day of Christmas my true love gave to me: ").toString();
        for(;verseNumber>0;verseNumber--)
            setence+= new StringBuilder().append(messages[verseNumber-1]).toString();
        return setence+"\n";
    }

    String verses(int startVerse, int endVerse) {
        String retorno = "";
        for (int i = startVerse; i <= endVerse; i++) {
            retorno += verse(i);
            if(i!=endVerse)
                retorno+="\n";
        }
        return retorno;
    }
    
    String sing() {
        return verses(1,12);
    }
}
