
package com.mycompany.LindokuhleAtWork;

import javax.swing.JOptionPane;

/**
 *
 * @author Lindokuhle Zwane
 */
public class CreateAccount {

    // Declare the private variables
    private String name;
    private String surname;
    private String username;
    private String password;

    // Constructor method
    public CreateAccount() {
        this.name = "";
        this.surname = "";
        this.username = "";
        this.password = "";
    }

    // This method ensures that any username contains an underscore(_) and is no more than 5 characters in length
    public boolean checkUsername() {
        return username.length() <= 5 && username.contains("_");
    }

    // This method ensures that passwords meet the following password complexity rules
    public boolean checkPasswordComplexity() {
        // Password must be at least 8 characters with a capital letter, number, and special character
        return password.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=!]).{8,}$");
    }

    // This method registers a new user
    public String registerUser(String name, String surname, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;

        while (!checkUsername()) {
            JOptionPane.showMessageDialog(null, "Invalid Username! Username is not correctly formatted,\nPlease ensure that your username contains an underscore(_) and is no more than 5 characters in length.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            this.username = JOptionPane.showInputDialog(null, "Enter a username", "Registration", JOptionPane.QUESTION_MESSAGE);
            if (this.username == null) {
                return "Registration cancelled.";
            }
        }

        while (!checkPasswordComplexity()) {
            JOptionPane.showMessageDialog(null, "Invalid Password! Password is not correctly formatted,\nPlease ensure that the password contains at least \n8 characters, a capital letter, a number and a special character.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            this.password = JOptionPane.showInputDialog(null, "Enter a password", "Registration", JOptionPane.QUESTION_MESSAGE);
            if (this.password == null) {
                return "Registration cancelled.";
            }
        }
        return "Registration successful!";
    }

    // This method verifies that the login details entered matches the login details stored when the user registers.
    public boolean loginUser(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    // This method returns the necessary messaging for:
    public String returnLoginStatus(String username, String password) {
        if (loginUser(username, password)) {
            return "Successful to Login! Welcome " + name + " " + surname + ", it is great to see you again.";
        } else {
            return "Failed to Login";
        }
    }
}
