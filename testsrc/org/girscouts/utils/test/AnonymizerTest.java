package org.girscouts.utils.test;

import org.girscouts.utils.Anonymizer;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class AnonymizerTest {

    @Test
    public void anonStringNullTest() {
        assertNull(Anonymizer.anonString(null));
    }
    @Test
    public void anonStringEmptyTest() {
        assertEquals(Anonymizer.anonString("").length(),0);
    }

    @Test
    public void anonStringRandomTest() {
        String piiString = "HelloWorld";
        String randomStr = Anonymizer.anonString(piiString);
        System.out.println(randomStr);
        assertTrue(piiString.length() == randomStr.length());
        assertTrue(!randomStr.equals(piiString));
    }

    @Test
    public void anonNumberNullTest() {
        assertNull(Anonymizer.anonInteger(null));
    }

    @Test
    public void anonNumberRandomTest() {
        System.out.println(Anonymizer.anonInteger(12));
        assertTrue(Anonymizer.anonInteger(10) != 10);
    }

    @Test
    public void anonEmailNullTest() {
        assertNull(Anonymizer.anonEmail(null));
    }

    @Test
    public void anonEmailRandomTest() {
        String piiEmail = "test.test@gmail.com";
        String rndEmail = Anonymizer.anonEmail(piiEmail);
        System.out.println(rndEmail);
        assertTrue(piiEmail.length() == rndEmail.length());
        assertTrue(!Anonymizer.anonEmail(piiEmail).equals(piiEmail));
    }
    @Test
    public void anonEmail2RandomTest() {
        String piiEmail = "test.test@test.gmail.com";
        String rndEmail = Anonymizer.anonEmail(piiEmail);
        System.out.println(rndEmail);
        assertTrue(piiEmail.length() == rndEmail.length());
        assertTrue(!Anonymizer.anonEmail(piiEmail).equals(piiEmail));
    }

    @Test
    public void anonDateNullTest() {
        assertNull(Anonymizer.anonDate(null));
    }

    @Test
    public void anonDateChangeTest() {
        Calendar calNow = Calendar.getInstance();
        Calendar calChanged = Calendar.getInstance();
        Date now = new Date();
        Date changed = Anonymizer.anonDate(now);
        calNow.setTime(now);
        calChanged.setTime(changed);
        System.out.println("now : "+now);
        System.out.println("changed : "+changed);
        assertTrue(calNow.get(Calendar.DAY_OF_MONTH) != calChanged.get(Calendar.DAY_OF_MONTH));
        assertTrue(calNow.get(Calendar.MONTH) == calChanged.get(Calendar.MONTH));
    }

    @Test
    public void anonPhoneNullTest() {
        assertNull(Anonymizer.anonPhoneNumber(null));
    }

    @Test
    public void anonPhoneRandomTest() {
        String piiPhone = "(121)-123-1231";
        String randomPhone = Anonymizer.anonPhoneNumber(piiPhone);
        System.out.println(randomPhone);
        assertTrue(piiPhone.length() == randomPhone.length());
        assertTrue(!randomPhone.equals(piiPhone));
    }
    @Test
    public void anonPhoneRandom2Test() {
        String piiPhone = "(123) 456-7890";
        String randomPhone = Anonymizer.anonPhoneNumber(piiPhone);
        System.out.println(randomPhone);
        assertTrue(piiPhone.length() == randomPhone.length());
        assertTrue(!randomPhone.equals(piiPhone));
    }
    @Test
    public void anonPhoneRandom3Test() {
        String piiPhone = "(123)456-7890";
        String randomPhone = Anonymizer.anonPhoneNumber(piiPhone);
        System.out.println(randomPhone);
        assertTrue(piiPhone.length() == randomPhone.length());
        assertTrue(!randomPhone.equals(piiPhone));
    }
    @Test
    public void anonPhoneRandom4Test() {
        String piiPhone = "1234567890";
        String randomPhone = Anonymizer.anonPhoneNumber(piiPhone);
        System.out.println(randomPhone);
        assertTrue(piiPhone.length() == randomPhone.length());
        assertTrue(!randomPhone.equals(piiPhone));
    }
}