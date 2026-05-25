/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//Pakage Files
package com.mycompany.poeassignment;

/**
 *
 * @author ST10521871 Mmola Matlou
 */

//Imports of Scanner
import java.util.Scanner;

//Main Class
public class POEAssignment {

    public static void main(String[] args) {
        
       //Declared my Scanner
       Scanner input = new Scanner(System.in);
        
      //This object allows me to use all the methods inside the LoginClass.
     LoginClass login = new LoginClass();
        
    //User must enter Registration Details. 
      System.out.println("<<<<< USER REGISTRATION >>>>>");
      
      //User must enter First Name
        System.out.println("Enter First Name: ");
       String firstName = input.nextLine();
        
      //User must enter Last Name
        System.out.println("Enter Last Name: ");
        String lastName = input.nextLine();

     //User must enter Username with the following requirements
        String username;
        do {
           System.out.println("Enter Username (must contain '_' and max 5 characters): ");
            username = input.nextLine();
         //If username is correct
            if (login.checkUserName(username)) {
                System.out.println("Username successfully captured");
                
                //if username is incorrect
            } else {
                System.out.println("Username incorrectly formatted.\nPlease ensure it contains an underscore\nand is no more than five characters long.");
            }
        //End loop
        } while (!login.checkUserName(username));

        
           // User must create a password with the following requirements
             String password;
        do {
            System.out.println("Enter Password (8+ chars, capital, number, special char): ");
            password = input.nextLine();
            
           //if password is entered correctly
           if (login.checkPasswordComplexity(password)) {
                System.out.println("Password successfully captured");
                
                // if Password is not entered correctly
            } else {
                System.out.println("Password is not correctly formatted.\nPlease esnure that the password contains 8 characters, \nA Capital letter, A Number and A Special charater.");
            }
        //End Loop
        } while (!login.checkPasswordComplexity(password));
        
        
         // User must Enter CellphoneNumber
         //Loop added
         String number;
         do {
            System.out.println("Enter Cellphone Number Starting with an international code(South Africa) (+27...): ");
            number = input.nextLine();
            
           //if user entered an international code
            if (login.checkCellphoneNumber(number)) {
                System.out.println("Cellphone number successfully added.");
                
            //If user entered the wrong international code or it has less or more numbers
            } else {
                System.out.println("Cell phone number incorrectly formated or \nDoes not contain international code.");
            }
         //end loop
        } while (!login.checkCellphoneNumber(number));

        // Register the user and the data is stored.
        System.out.println(login.registerUser(username, password, number, firstName, lastName));

        // User must enter login details
        System.out.println("\n<<<<< LOGIN >>>>");
        //Message if the user enterd the correct login details
        boolean success;
        //Loop added
        do {
            //User must enter login Details
            System.out.println("Enter Username: ");
            String loginusername = input.nextLine();
           
            System.out.println("Enter Password: ");
            String loginpassword = input.nextLine();
            
            
           //My message should display if the username and password are entered correctly
            success = login.loginUser(loginusername, loginpassword);
           //Not correct
            if (!success) {
                //if either username or password are entered incorrectly
                System.out.println("Username or password incorrect. Try again.");
            }
        //end loop
        } while (!success);
        //Display Messsaage
        System.out.println(login.returnLoginStatus(success));
        
        //Welcome Message
        System.out.println("\nWelcome to QuickChat.");

        //Ask user number of messages
        System.out.println("How many messages would you like to send?");
        int totalMessages = input.nextInt();
        input.nextLine();

        //Main Menu Option
        int option;

        //Do While Loop
        do {
            

           //Main Menu
            System.out.println("\nChoose an option:");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");

            option = input.nextInt();
            input.nextLine();

            switch (option) {

                // SEND MESSAGES
               //Option 1
                case 1:

                    //For Loop - runs for the number of messages user wants to send
                    for (int i = 1; i <= totalMessages; i++) {

                        //Number of messages
                        System.out.println("\nMessage " + i + " of " + totalMessages);

                        //Number of Recipient
                        System.out.println("Enter Recipient Number:");
                        String recipient = input.nextLine();

                        //Message Text
                        System.out.println("Enter your message:");
                        String messageText = input.nextLine();

                        //Message Object (linking the message class)
                        Message message = new Message
                        (i, recipient, messageText);

                        //Check Recipient Number
                        System.out.println
                        (message.checkRecipientCell());

                        //Check Message Length
                        System.out.println
                        (message.checkMessageLength());

                        //Only continue if both are valid
                        if (message.checkRecipientCell()
                                .equals("Cell phone number successfully captured.")
                                &&
                            message.checkMessageLength()
                                .equals("Message ready to send.")) {

                      //Message Options
                      System.out.println("\nChoose an option:");
                      System.out.println("1) Send Message");
                      System.out.println("2) Store Message");
                      System.out.println("3) Disregard Message");
                         
                           //Declaration if message option
                          int messageOption = input.nextInt();
                          input.nextLine();

                          switch (messageOption) {

                          //Send Message
                                case 1:

                                    System.out.println
                                    (message.sentMessage("send"));

                                    //Display Message Details
                                    System.out.println
                                    (message.printMessages());

                                    break;

                                //Store Message
                                case 2:

                                    System.out.println
                                    (message.sentMessage("store"));

                                    break;

                                //Disregard Message
                                case 3:

                                    System.out.println
                                    (message.sentMessage("disregard"));

                                    break;

                                default:

                                    System.out.println
                                    ("Invalid option.");
                            }
                      }
                 }

                    //Display total messages after all messages have been sent
                    System.out.println("\nTotal Messages Sent: " + new Message(0, "", "placeholder").returnTotalMessages());

                    break;

               //Outcome of option 2
                case 2:

                    System.out.println("Coming Soon.");

                    break;

               // Outcome of option 3
                case 3:

                    System.out.println("Goodbye.");

                    break;
               //None of THE OPTIONS
                default:

                    System.out.println("Invalid option.");
            }

        //End do while loop
        } while (option != 3);


        //Close Scanner
        input.close();
    }
}