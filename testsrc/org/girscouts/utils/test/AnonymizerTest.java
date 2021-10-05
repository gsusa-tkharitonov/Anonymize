package org.girscouts.utils.test;

import org.girscouts.utils.Anonymizer;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnonymizerTest {

    @Test
    public void anonStringNullTest() {
        assertNull(Anonymizer.AnonString(null));
    }
    @Test
    public void anonStringEmptyTest() {
        assertEquals(Anonymizer.AnonString("").length(),0);
    }

    @Test
    public void anonStringRandomTest() {
        String piiString = "HelloWorld";
        String randomStr = Anonymizer.AnonString(piiString);
        System.out.println(randomStr);
        assertTrue(piiString.length() == randomStr.length());
        assertTrue(!randomStr.equals(piiString));
    }

    @Test
    public void anonNumberNullTest() {
        assertNull(Anonymizer.AnonNumber(null));
    }

    @Test
    public void anonNumberRandomTest() {
        System.out.println(Anonymizer.AnonNumber(12));
        assertTrue(Anonymizer.AnonNumber(10) != 10);
    }

    @Test
    public void anonEmailNullTest() {
        assertNull(Anonymizer.AnonEmail(null));
    }

    @Test
    public void anonEmailRandomTest() {
        String piiEmail = "test@gmail.com";
        String rndEmail = Anonymizer.AnonEmail(piiEmail);
        System.out.println(rndEmail);
        assertTrue(piiEmail.length() == rndEmail.length());
        assertTrue(!Anonymizer.AnonEmail(piiEmail).equals(piiEmail));
    }

    @Test
    public void anonDateNullTest() {
        assertNull(Anonymizer.AnonDate(null));
    }
}