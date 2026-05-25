/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poeassignment;
/**
 *
 * @author ST10521871 Mmola Matlou
 */
//Login class
public class LoginClass {
   //Users Stored information
   private String storedUsername;
   private String storedPassword;
   private String firstName;
   private String lastName;

    // Username method checker
    public boolean checkUserName(String username) {
        //checks if it has a underscore and is 5 characters in length
        return username.contains("_") && username.length() <= 5;
    }

    // Password method checker
    public boolean checkPasswordComplexity(String password) {
             //Checks if it is 8 characters long
        return password.length() >= 8 &&
                //Checcks if it contains a Capital letter
              password.matches(".*[A-Z].*") &&
                //Checcks if it contains a Number
              password.matches(".*[0-9].*") &&
                //Checks if it conatains a Special Character
              password.matches(".*[!@#$%^&*()].*");
    }

    // CELLPHONE moethod checker (REGEX used)
    public boolean checkCellphoneNumber(String number) {
        //Checks if it has a international code, Numbers from 0 to 9 and is 9 characters long 
        //together they create 10 numbers including international code and the 9 numbers
        return number.matches("\\+27[0-9]{9}");
    }

    // Register the user
    public String registerUser(String username, String password, String number, String firstName, String lastName) {
    //Register user username and password
        if (!checkUserName(username)) {
            return "Username is incorrectly formatted.";
       }

        if (!checkPasswordComplexity(password)) {
            return "Password does not meet complexity requirements.";
        }

        if (!checkCellphoneNumber(number)) {
            return "Cellphone number incorrectly formatted.";
        }
       // Store details
        this.storedUsername = username;
        this.storedPassword = password;
        this.firstName = firstName;
        this.lastName = lastName;
      //Display message when user done entering details
        return "User successfully registered!";
    }

    // Login user method
    public boolean loginUser(String username, String password) {
        //This check if the registerd information matches with the login information.
        return username.equals(storedUsername) && password.equals(storedPassword);
    }

  // Login status method and message
    public String returnLoginStatus(boolean success) {
        //Message
        if (success) {
           
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again. ";
            
           //If the user enters the incorrect login details
        } else {
            return "Username or password incorrect, Please try again";
        }
    }
}