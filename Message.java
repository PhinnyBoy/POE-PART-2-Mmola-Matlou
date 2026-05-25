/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poeassignment;

/**
 *
 * @author ST10521871 Mmola Matlou
 */

//Imports
//Stores messages
import java.util.ArrayList;
//Creates the list
import java.util.List;
//Joins text together
import java.util.stream.Collectors;
//Writes into a file
import java.io.FileWriter;
//Handles saving errors
import java.io.IOException;
//Creates random Message ID
import java.util.Random;

//Message Class
public class Message {

    //Variables
    private String messageID;
    private String recipient;
    private String messageText;
    private String messageHash;
    private int messageNumber;

 //ArrayList
 private static final List<String> sentMessages = new ArrayList<>();

    //Constructor
    public Message(int messageNumber, String recipient, String messageText) {

        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;

        //Creates a Message ID
        createMessageID();

        //Creates a Hash
        createMessageHash();
    }

    //Creates Message ID
    public void createMessageID() {
        //Opject
        Random random = new Random();

        //Random 10 digit number
        long randomNumber = 1000000000L + (long) (random.nextDouble() * 9000000000L);

        messageID = String.valueOf(randomNumber);
    }

    //Check Message ID
    public boolean checkMessageID() {

        //Must be 10 digits long
        return messageID.length() == 10;
    }

//Check Recipient Cell Number
//Check Recipient Number
public String checkRecipientCell() {

    //Valid Number
    if (recipient.matches("\\+27[0-9]{9}")) {

        return "Cell phone number successfully captured.";
    }

    //Invalid Number
    else {

        return "Cell phone number is incorrectly formatted or does not contain an international code.";
    }
}

    //Check Message Length
public String checkMessageLength() {

    //Message valid
    if (messageText.length() <= 250) {

        return "Message ready to send.";
    }

    //Message invalid
    else {
        //If message exceeds 250 words
        int exceeded = messageText.length() - 250;

        return "Message exceeds 250 characters by "
                + exceeded + ", please reduce size.";
    }
}

    //Create Message Hash
public String createMessageHash() {

    //Split message into words
    String[] words = messageText.split(" ");

    //First word
    String firstWord = words[0].toUpperCase();

    //Last word
    String lastWord = words[words.length - 1]
            .replace("?", "")
            .replace(".", "")
            .toUpperCase();

    //First 2 digits of Message ID
    String firstNumbers = messageID.substring(0, 2);

    //Create Hash
    messageHash = firstNumbers + ":" + messageNumber + ":" + firstWord + lastWord;

    return messageHash;
}

    //Send Message Method
    public String sentMessage(String option) {

        switch (option.toLowerCase()) {
            //Options
            //Option 1
            case "send":
                
                sentMessages.add(messageText);

                return "Message successfully sent.";
                
                //Option 2
             case "store":
                    
                storeMessage();
                
                return "Message successfully stored.";
                
              //Option 3
             case "disregard":

                return "Press 0 to delete message.";

             default:
             //Entered wrong option
                return "Invalid option.";
        }
    }

    //Display Message Details
   public String printMessages() {

    //Stores message details inside ArrayList
    List<String> messageDetails = new ArrayList<>();

    //Store information
    messageDetails.add("Message ID: " + messageID);
    messageDetails.add("Message Hash: " + messageHash);
    messageDetails.add("Recipient: " + recipient);
    messageDetails.add("Message: " + messageText);
   

    //Returns all details together
    //String manipulation
    return messageDetails.stream()
            .collect(Collectors.joining("\n"));
}

    //Total Messages
    public int returnTotalMessages() {

    //total amount of sent messages
    return sentMessages.stream().collect(Collectors.toList()).size();
}

    //Store JSON File
    //Reasearch
    //Imports take Part
    public void storeMessage() {

        try {

            //Create JSON File
            FileWriter file = new FileWriter("messages.json", true);

            //Write into JSON file
            file.write("{\n");
            file.write("\t\"MessageID\": \"" + messageID + "\",\n");
            file.write("\t\"MessageHash\": \"" + messageHash + "\",\n");
            file.write("\t\"Recipient\": \"" + recipient + "\",\n");
            file.write("\t\"Message\": \"" + messageText + "\"\n");
            file.write("}\n\n");

            //Close File
            file.close();
         //The import
        } catch (IOException e) {
         
            System.out.println("Error saving message.");
        }
    }
}