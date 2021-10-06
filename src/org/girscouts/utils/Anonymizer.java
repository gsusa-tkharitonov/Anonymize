package org.girscouts.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Anonymizer {
    public static String anonString(String piiString) {
        if(piiString == null) return null;
        if(piiString.isEmpty()) return "";
        return generateString(piiString);
    }

    public static Integer anonNumber(Integer piiNumber) {
        Random rnd = new Random();
        if(piiNumber == null) return null;
        int rndNumber = 0;
        while(rndNumber == 0){
            rndNumber = rnd.nextInt(piiNumber);
        }
        return rndNumber;
    }

    public static String anonEmail(String piiEmail) {
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

    public static Date anonDate(Date piiDate) {

        if(piiDate == null) return null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(piiDate);
        cal.add(Calendar.DAY_OF_MONTH, anonNumber(30));
        return cal.getTime();
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
    public static void main(String[] args) {
        System.out.println("Test String : "+anonString("Test String"));
        System.out.println("Number 12 : "+anonNumber(12));
        System.out.println("TestEmail@Test.com : "+anonEmail("TestEmail@Test.com"));
        Date now = new Date();
        System.out.println(now +" : "+anonDate(now));
    }

}
