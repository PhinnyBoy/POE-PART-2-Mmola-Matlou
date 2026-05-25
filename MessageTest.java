/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poeassignment;

/**
 *
 * @author ST10521871 Mmola Matlou
 */

//Imports
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//Message Test Class
public class MessageTest {

    //Message Length Test
    @Test
    public void testCheckMessageLength() {

        //Valid Message
        Message message1 = new Message
        (1, "+27718693002",
        "Hi Mike can you join us for dinner tonight");

        //Success
        assertEquals("Message ready to send.",
                message1.checkMessageLength());

        //Invalid Message
        Message message2 = new Message
        (2, "+27718693002",
        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        //Failure
        assertTrue(message2.checkMessageLength().contains("Message exceeds 250 characters"));
    }

    //Recipient Number Test
    @Test
    public void testCheckRecipientCell() {

        //Valid Number
        Message message1 = new Message
        (1, "+27718693002", "Hello");

        //Success
        assertEquals
        ("Cell phone number successfully captured.", message1.checkRecipientCell());

        //Invalid Number
        Message message2 = new Message
        (2, "0812345678","Hello");

        //Failure
        assertEquals
        ("Cell phone number is incorrectly formatted or does not contain an international code.", message2.checkRecipientCell());
    }

    //Message ID Test
    @Test
    public void testCheckMessageID() {

        //Object
        Message message = new Message
        (1, "+27718693002", "Hi Mike, can you join us for dinner tonight?");

        //Expected Result
        assertEquals(true,message.checkMessageID());
    }

    //Message Hash Test
    @Test
    public void testCreateMessageHash() {

        //Object - Test Data Task 1
        Message message = new Message
        (0, "+27718693002",
        "Hi Mike, can you join us for dinner tonight?");

        //Hash must not be null
        assertNotNull(message.createMessageHash());

        //Hash must contain first word
        assertTrue(message.createMessageHash()
                .contains("HI"));

        //Hash must contain last word - tonight without punctuation
        assertTrue(message.createMessageHash()
                .contains("TONIGHT"));

        //Hash must follow correct format: XX:0:FIRSTWORDLASTWORD
        assertTrue(message.createMessageHash()
                .contains(":0:"));
    }

    //Send Message Test
    @Test
    public void testSentMessage() {

        //Object
        Message message = new Message
        (1, "+27718693002","Hello");

        //Send
        assertEquals("Message successfully sent.",
                message.sentMessage("send"));

        //Store
        assertEquals("Message successfully stored.",
                message.sentMessage("store"));

        //Disregard
        assertEquals("Press 0 to delete message.",
                message.sentMessage("disregard"));
    }

   //Return Total Messages Test
    @Test
    public void testReturnTotalMessages() {

    //Message 1  Test Data Task 1
    Message message1 = new Message
    (1, "+27718693002",
    "Hi Mike, can you join us for dinner tonight?");

    //Message 2  Test Data Task 2
    Message message2 = new Message
    (2, "+27718693002",
    "Hi Keegan, did you receive the payment?");

    //Send Messages
    message1.sentMessage("send");
    message2.sentMessage("send");

    //Expected Result - total must be greater than 0
    assertTrue(message1.returnTotalMessages() >= 2);
}
}