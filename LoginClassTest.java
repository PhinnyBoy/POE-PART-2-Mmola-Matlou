/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poeassignment;
/**
 *
 * @author ST10521871 Mmola Matlou
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginClassTest {

    // Userrname test
    @Test
   public void testCheckUserName() {
     LoginClass login = new LoginClass();
         //valid
        assertEquals(true, login.checkUserName("kyl_1")); 
     //invalid
       assertEquals(false, login.checkUserName("kyle!!!!")); 
    }

    //Password test
    @Test
    public void testCheckPasswordComplexity() {
        LoginClass login = new LoginClass();
      //Valid
        assertEquals(true, login.checkPasswordComplexity("Password1!"));
        //invalid
      assertEquals(false, login.checkPasswordComplexity("pasworrd"));
    }

    // Cellphone test
    @Test
    public void testCheckCellphoneNumber() {
        LoginClass login = new LoginClass();
        //valid
      assertEquals(true, login.checkCellphoneNumber("+27831234567"));
        //invalid
      assertEquals(false, login.checkCellphoneNumber("0834567312"));
    }

    // Register user test
    @Test
   public void testRegisterUser() {
       LoginClass login = new LoginClass();
        //Valid
       String result = login.registerUser("kyl_1", "Password1!", "+27831234567", "Khutso", "Matlou");

        assertEquals("User successfully registered!", result);
    }

    // LOGIN TEST
    @Test
    public void testLoginUser() {
        LoginClass login = new LoginClass();

        login.registerUser("kyl_1", "Password1!", "+27831234567", "Khutso", "Matlou");

        assertEquals(true, login.loginUser("kyl_1", "Password1!"));
        //Invalid
        assertEquals(false, login.loginUser("Kyle!!!!", "Password"));
    }

    // LOGIN STATUS TEST
    @Test
    public void testReturnLoginStatus() {
        LoginClass login = new LoginClass();

        login.registerUser("kyl_1", "Password1!", "+27831234567", "Khutso", "Matlpo");
        //Valid
        assertEquals("Welcome Khutso Matlou, it is great to see you.", 
                     login.returnLoginStatus(true));
         //Invalid
        assertEquals("Username or password incorrect. Try again", 
                     login.returnLoginStatus(false));
    }
}