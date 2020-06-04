package edu.ti.caih313.collections.dataobj;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmailAddressTest {

    EmailAddress devorah, drAllen, yehuda, johnDoe;

    @Before
    public void makeTester()
    {
        devorah = new EmailAddress("devorahlevi1@gmail.com", EmailAddress.Type.HOME);
        devorah.emailMap.put(EmailAddress.Type.SCHOOL, "devorah.levi@ti.htc.edu");
        devorah.emailMap.put(EmailAddress.Type.WORK, "levi.devorah@careonerx.com");

        drAllen = new EmailAddress("mallen@htc.edu", EmailAddress.Type.SCHOOL);
        drAllen.emailMap.put(EmailAddress.Type.WORK, "mallen@ccis.com");

        yehuda = new EmailAddress("yehudalevi@icloud.com", EmailAddress.Type.HOME);

        johnDoe = new EmailAddress("johndoe@gmail.com", EmailAddress.Type.HOME);
        johnDoe.emailMap.remove(EmailAddress.Type.HOME);
    }

    @Test
    public void testGetPrimaryEmailAddress()
    {
        String primaryEmailAddress = devorah.getEmailAddress();
        assertEquals("devorahlevi1@gmail.com", primaryEmailAddress);

        String primaryEmailAddress1 = drAllen.getEmailAddress();
        assertEquals("mallen@ccis.com", primaryEmailAddress1);

        String primaryEmailAddress2 = yehuda.getEmailAddress();
        assertEquals("yehudalevi@icloud.com", primaryEmailAddress2);

        String primaryEmailAddress3 = johnDoe.getEmailAddress();
        assertNull(primaryEmailAddress3);
    }

    @Test
    public void testGetEmailAddress()
    {
        String emailAddress = devorah.getEmailAddress(EmailAddress.Type.HOME);
        assertEquals("devorahlevi1@gmail.com", emailAddress);

        String emailAddress1 = devorah.getEmailAddress(EmailAddress.Type.WORK);
        assertEquals("levi.devorah@careonerx.com", emailAddress1);

        String emailAddress2 = devorah.getEmailAddress(EmailAddress.Type.SCHOOL);
        assertEquals("devorah.levi@ti.htc.edu", emailAddress2);

        String emailAddress3 = johnDoe.getEmailAddress(EmailAddress.Type.HOME);
        assertNull(emailAddress3);
    }

    @Test
    public void testEmailToString()
    {
        String toString = devorah.toString();
        assertEquals("<HOME: devorahlevi1@gmail.com, WORK: levi.devorah@careonerx.com, SCHOOL: devorah.levi@ti.htc.edu>", toString);

        String toString1 = drAllen.toString();
        assertEquals("<WORK: mallen@ccis.com, SCHOOL: mallen@htc.edu>", toString1);

        String toString2 = yehuda.toString();
        assertEquals("<HOME: yehudalevi@icloud.com>", toString2);

        String toString3 = johnDoe.toString();
        assertEquals("<No email address available.>", toString3);
    }
}