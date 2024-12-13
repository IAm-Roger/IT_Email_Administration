/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emailapp;

import java.util.Scanner;
/**
 *
 * @author comic
 */
public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String alternativeEmail;
    private String email;
    private String companySuffix = ".company.com";
    private int passwordSetLength = 10;
    private int mailboxCapacity = 500;
    //constructor asking for first and last name
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        //System.out.println("Account Created: " + this.firstName + "." + this.lastName);
        this.department = setDepartment();
        System.out.println("Department: " + this.department);
        
        this.password = randomPassword(passwordSetLength);
        System.out.println("Password has been set: " + this.password);
        
        //generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + companySuffix;
        System.out.println("Email generated in format: FirstName.LastName@DepartmentName.CompanySuffix");
    }
    
    //ask and get department
    private String setDepartment(){
        System.out.print("DEPARTMENT CODES\n1: Sales\n2: Development\n3: Accounting\n0: To quit\n");
        Scanner in = new Scanner(System.in);
        int departmentChoice = in.nextInt();
        return switch (departmentChoice) {
            case 1 -> "Sales";
            case 2 -> "Development";
            case 3 -> "Accounting";
            default -> "PlaceHolder";
        }; 
    }
    //generate a random password
    private String randomPassword(int length){
        this.passwordSetLength = length;
        String passwordSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%";
        char[] password = new char[length];
        for (int i=0; i<length; i++)
        {
            int randNum = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(randNum);
        }
        return new String(password);
    }
    //change password
    public void changePassword(){
        Scanner readInput = new Scanner(System.in);
        String currentPassword = (String) readInput.nextLine();
        if(currentPassword.equals(this.password))
        {
            System.out.println("Please enter a new password: ");
            String newPassword = "temp";
            String lowerCases = "abcdefghijklmnopqrstuvwxyz";
            String upperCases = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String numbers = "1234567890";
            String specialChars = "!@#$%";
            while(newPassword.length() < 6)
            {
                newPassword = readInput.nextLine();
                if(newPassword.length() < 6 && !(newPassword.contains(lowerCases)) && !(newPassword.contains(upperCases)) && 
                                                !(newPassword.contains(numbers)) && !(newPassword.contains(specialChars)))
                {
                System.out.println("Password Not Allowed, Try Again");
                }
                else
                {
                   this.password = newPassword; 
                   System.out.println("New Password Is Now: " + newPassword);
                }
            }    
        }
        else
        {
            System.out.println("Wrong Password, try again");
        }
    }
    //set mailbox capacity
    public void setMailboxCapacity(int mailCapacity){
        this.mailboxCapacity = mailCapacity;
    }
    //set alternative email
    public void setAlternativeEmail(String altEmail)
    {
        this.alternativeEmail = altEmail;
    }
    
    //get mail box capacity
    public int getMailboxCapacity(){ return mailboxCapacity; }
    //get alternative email
    public String getAlternativeEmail(){ return alternativeEmail; }
    //get current password
    public String getCurrentPassword(){ return password; }
    
    public String toString(){
        return "User Name: " + firstName + " " + lastName +
                "\nEmail: " + email + 
                "\nEmail Capacity: " + mailboxCapacity;
    }
}
