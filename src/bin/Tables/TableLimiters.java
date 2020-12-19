package bin.Tables;

import bin.Enumirations.IndicesTables;
import bin.Items.Token;

import java.util.Arrays;
import java.util.List;

public class TableLimiters implements Tables<Token> {
    private final static Token[] limiters= {
            new Token("NE",  IndicesTables.LIMITERS,0),
            new Token("EQ",IndicesTables.LIMITERS,1),
            new Token("LT",IndicesTables.LIMITERS,2),
            new Token("LE",IndicesTables.LIMITERS,3),
            new Token("GT",IndicesTables.LIMITERS,4),
            new Token("GE",IndicesTables.LIMITERS,5),
            new Token("plus",IndicesTables.LIMITERS,6),
            new Token("min",IndicesTables.LIMITERS,7),
            new Token("or",IndicesTables.LIMITERS,8),
            new Token("mult",IndicesTables.LIMITERS,9),
            new Token("div",IndicesTables.LIMITERS,10),
            new Token("and",IndicesTables.LIMITERS,11),
            new Token("ass",IndicesTables.LIMITERS,12),
            new Token("~",IndicesTables.LIMITERS,13),
            new Token("(",IndicesTables.LIMITERS,14),
            new Token(")",IndicesTables.LIMITERS,15),
            new Token(":",IndicesTables.LIMITERS,16),
            new Token(";",IndicesTables.LIMITERS,17),
            new Token(",",IndicesTables.LIMITERS,18),
            new Token(".",IndicesTables.LIMITERS,19),
            new Token("%",IndicesTables.LIMITERS,19),
            new Token("\n",IndicesTables.LIMITERS,20)
    };

    public TableLimiters(){}

    public static Token[] getLimiters() {
        return limiters;
    }

    @Override
    public boolean contains(String word){
        for (int i = 0; i < limiters.length; i++) {
            if (limiters[i].getItem().equals(word)){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Token> getListElements(){
        return Arrays.asList(limiters);
    }


    @Override
    public  Token getElement(String limiter) {
        if (!contains(limiter)){
            try {
                throw new Exception("Данного значения:" +limiter+" нет в таблице огранечителей");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < limiters.length; i++) {
            if (limiters[i].getItem().equals(limiter)){
                return limiters[i];
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Token token: limiters ) {
            stringBuilder.append(token.toString()).append("\n");
        }
        return stringBuilder.toString();
    }


}
