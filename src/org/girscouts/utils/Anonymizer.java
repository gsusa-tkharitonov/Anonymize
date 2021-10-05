package org.girscouts.utils;

import java.util.Random;

public class Anonymizer {
    public static String AnonString(String piiString) {
        if(piiString == null) return null;
        if(piiString.isEmpty()) return "";
        return generateString(piiString);
    }

    public static Integer AnonNumber(Integer piiNumber) {
        Random rnd = new Random();
        if(piiNumber == null) return null;
        int rndNumber = 0;
        while(rndNumber == 0){
            rndNumber = rnd.nextInt(piiNumber);
        }
        return rndNumber;
    }

    public static String AnonEmail(String piiEmail) {
        Random rnd = new Random();
        String dotStr = "\\.";
        String rndEmail = "";
        if(piiEmail == null) return null;
        if(piiEmail.isEmpty()) return "";
        String[] emailParts = piiEmail.split("@");
        rndEmail += generateString(emailParts[0]);
        if(emailParts.length>1){
            String[] hostParts = emailParts[1].split(dotStr);
            rndEmail += "@"+generateString(hostParts[0]);
            if(hostParts.length>1){
                rndEmail += "." + generateString(hostParts[1]);
            }
        }
        return rndEmail;
    }

    public static String AnonDate(String piiDate) {
        if(piiDate == null) return null;
        if(piiDate.isEmpty()) return "";
        return null;
    }

    static String generateString(String characters)
    {
        Random rnd = new Random();
        int strLength = characters.length();
        char[] text = new char[strLength];
        for (int i = 0; i < strLength; i++)
        {
            text[i] = characters.charAt(rnd.nextInt(characters.length()));
        }
        return new String(text);
    }
}
