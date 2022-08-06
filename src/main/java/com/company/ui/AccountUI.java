package com.company.ui;

import com.company.enums.CommandColors;
import com.company.model.Account;
import com.company.settings.Setting;
import com.company.utility.DataUtility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class AccountUI {

    public static String createFirstNameForm(Scanner scanner, String old, boolean required) {
        String firstName = null;
        while (true) {
            if (old == null && required) {
                System.out.println("Enter Your First Name :");
                firstName = scanner.nextLine();

                if (firstName.trim().equals(".")) {
                    System.out.println(CommandColors.ANSI_RED + "You Cant Choose ((.)) For Your First Name");
                    System.out.print(CommandColors.ANSI_RESET);
                    continue;
                }
                if (!DataUtility.isStringCorrectFirstNameOrLastName(firstName)) {
                    System.out.println(CommandColors.ANSI_RED + "Your FirstName Format IS Invalid.\nYou can only use a-z A-Z");
                    System.out.print(CommandColors.ANSI_RESET);
                    continue;
                }
            } else if (old != null && !required) {
                System.out.println(CommandColors.ANSI_BLUE + old);
                System.out.print(CommandColors.ANSI_RESET);
                System.out.println("Enter Your New First Name :(Or If You Dont Want Please Type ((.)) )");
                firstName = scanner.nextLine();
                if (firstName.trim().equals(".")){
                    return old;
                }
                if (!DataUtility.isStringCorrectFirstNameOrLastName(firstName)) {
                    System.out.println(CommandColors.ANSI_RED + "Your FirstName Format IS Invalid.\nYou can only use a-z A-Z");
                    System.out.print(CommandColors.ANSI_RESET);
                    continue;
                }
            } else if (old == null && !required) {

            } else if (old != null && required) {

            }
            return firstName;
        }
    }

    public static String createLastNameForm(Scanner scanner, String old, boolean required) {
        String lastName = null;
        while (true) {
            if (old == null && required) {
                System.out.println("Enter Your Last Name :");
                lastName = scanner.nextLine();
                if (lastName.trim().equals(".")) {
                    System.out.println(CommandColors.ANSI_RED + "You Cant Choose ((.)) For Your Last Name");
                    System.out.print(CommandColors.ANSI_RESET);
                    continue;
                }
                if (!DataUtility.isStringCorrectFirstNameOrLastName(lastName)) {
                    System.out.println(CommandColors.ANSI_RED + "Your FirstName Format IS Invalid.\nYou can only use a-z A-Z");
                    System.out.print(CommandColors.ANSI_RESET);
                    continue;
                }
            } else if (old != null && !required) {
                System.out.println(CommandColors.ANSI_BLUE + old);
                System.out.print(CommandColors.ANSI_RESET);
                System.out.println("Enter Your New Last Name :(Or If You Dont Want Please Type ((.)) )");
                lastName = scanner.nextLine();
                if (lastName.trim().equals(".")){
                    return old;
                }
                if (!DataUtility.isStringCorrectFirstNameOrLastName(lastName)) {
                    System.out.println(CommandColors.ANSI_RED + "Your FirstName Format IS Invalid.\nYou can only use a-z A-Z");
                    System.out.print(CommandColors.ANSI_RESET);
                    continue;
                }
            } else if (old == null && !required) {

            } else if (old != null && required) {

            }
            return lastName;
        }
    }

    public static String createPhoneNumberForm(Scanner scanner, String old, boolean required) {
        String phoneNumber = null;
        while (true) {

            if (old == null && required) {

            } else if (old != null && !required) {
                System.out.println(CommandColors.ANSI_BLUE + old);
                System.out.print(CommandColors.ANSI_RESET);
                System.out.println("Enter Your New PhoneNumber :(Or If You Dont Want Please Type ((.)) )");
                phoneNumber = scanner.nextLine();
                if(phoneNumber.equals(".")){
                    return  null;
                }
                if (!DataUtility.isStringOnlyNumber(phoneNumber)) {
                    System.out.println(CommandColors.ANSI_RED + "Your PhoneNumber Format IS Invalid.\nYou can only use 0-9");
                    System.out.print(CommandColors.ANSI_RESET);
                    continue;
                }
            } else if (old == null && !required) {
                System.out.println("Enter Your PhoneNumber :");
                phoneNumber = scanner.nextLine();
                if (!DataUtility.isStringOnlyNumber(phoneNumber)) {
                    System.out.println(CommandColors.ANSI_RED + "Your PhoneNumber Format IS Invalid.\nYou can only use 0-9");
                    System.out.print(CommandColors.ANSI_RESET);
                    continue;
                }
            } else if (old != null && required) {

            }
            return phoneNumber;
        }
    }

    public static LocalDate createBirthdayForm(Scanner scanner, LocalDate old, boolean required) throws ParseException {
        LocalDate birthDay = null;

        while (true) {
            if (old == null && required) {

            } else if (old != null && !required) {
                System.out.println(CommandColors.ANSI_BLUE + old);
                System.out.print(CommandColors.ANSI_RESET);
                System.out.println("Enter Your New BirthDay :(Or If You Dont Want Please Type ((.)) )");
                String birthDayStr = scanner.nextLine();

                if (birthDayStr.equals(".")) {
                    return old;
                }
                if (!DataUtility.isStringCorrectDate(birthDayStr)) {
                    System.out.println(CommandColors.ANSI_RED + "Your PhoneNumber Format IS Invalid.\nYou can only use 0-9 -");
                    System.out.print(CommandColors.ANSI_RESET);
                    continue;
                }

                Date date = new SimpleDateFormat("yyyy/MM/dd").parse(birthDayStr);
                birthDay = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            } else if (old == null && !required) {
                System.out.println("Enter Your BirthDay :");
                String birthDayStr = scanner.nextLine();

                if (birthDayStr.equals(".")) {
                    return old;
                }
                if(!DataUtility.isStringCorrectDate(birthDayStr)){
                    System.out.println(CommandColors.ANSI_RED + "Your PhoneNumber Format IS Invalid.\nYou can only use 0-9 -");
                    System.out.print(CommandColors.ANSI_RESET);
                    continue;
                }

                Date date = new SimpleDateFormat("yyyy/MM/dd").parse(birthDayStr);
                birthDay = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            } else if (old != null && required) {

            }
            return birthDay;
        }
    }

    public static String createBioForm(Scanner scanner, String old, boolean required) {
        String bio = null;

        if (old == null && required) {

        } else if (old != null && !required) {
            System.out.println(CommandColors.ANSI_BLUE + old);
            System.out.print(CommandColors.ANSI_RESET);
            System.out.println("Enter Your New Bio :(Or If You Dont Want Please Type ((.)) )");
            bio = scanner.nextLine();
        } else if (old == null && !required) {
            System.out.println("Enter Your Bio :");
            bio = scanner.nextLine();
        } else if (old != null && required) {

        }
        return bio;
    }

    public static String createPasswordForm(Scanner scanner, String old, boolean required) {
        while (true) {
            if (old == null && required) {
                System.out.println("Enter Password :");
                String password = scanner.nextLine();
                if (password.length() < Setting.PASSWORD_MIN_LENGTH) {
                    System.out.println(CommandColors.ANSI_RED + "Your Password Must Have At Least " + Setting.PASSWORD_MIN_LENGTH + " characters");
                    System.out.print(CommandColors.ANSI_RESET);
                    continue;
                } else if (password.length() > Setting.PASSWORD_MAX_LENGTH) {
                    System.out.println(CommandColors.ANSI_RED + "Your Password Must Have At Most " + Setting.PASSWORD_MAX_LENGTH + "  characters");
                    System.out.print(CommandColors.ANSI_RESET);
                    continue;
                }
                System.out.println("Repeat Your Password");
                String repeatedPassword = scanner.nextLine();

                if (password.equals(repeatedPassword)) {
                    return password;
                } else {
                    System.out.println(CommandColors.ANSI_RED + "Your Passwords Dont Match.Please Try Again.");
                    System.out.print(CommandColors.ANSI_RESET);
                }
            } else if (old != null && !required) {
                System.out.println("Enter Your New Password :");
                String password = scanner.nextLine();

                if (!password.equals(".")) {
                    if (password.length() < Setting.PASSWORD_MIN_LENGTH) {
                        System.out.println(CommandColors.ANSI_RED + "Your Password Must Have At Least " + Setting.PASSWORD_MIN_LENGTH + " characters");
                        System.out.print(CommandColors.ANSI_RESET);
                        continue;
                    } else if (password.length() > Setting.PASSWORD_MAX_LENGTH) {
                        System.out.println(CommandColors.ANSI_RED + "Your Password Must Have At Most " + Setting.PASSWORD_MAX_LENGTH + "  characters");
                        System.out.print(CommandColors.ANSI_RESET);
                        continue;
                    }

                    System.out.println("Repeat Your Password");
                    String repeatedPassword = scanner.nextLine();

                    if (password.equals(repeatedPassword)) {
                        return password;
                    } else {
                        System.out.println(CommandColors.ANSI_RED + "Your Passwords Dont Match.Please Try Again.");
                        System.out.print(CommandColors.ANSI_RESET);
                    }
                } else {
                    password = old;
                    return password;
                }
            } else if (old == null && !required) {

            } else if (old != null && required) {


                System.out.println("Enter Your New Password :");
                String password = scanner.nextLine();

                if (!password.equals(".")) {
                    if (password.length() < Setting.PASSWORD_MIN_LENGTH) {
                        System.out.println(CommandColors.ANSI_RED + "Your Password Must Have At Least " + Setting.PASSWORD_MIN_LENGTH + " characters");
                        System.out.print(CommandColors.ANSI_RESET);
                        continue;
                    } else if (password.length() > Setting.PASSWORD_MAX_LENGTH) {
                        System.out.println(CommandColors.ANSI_RED + "Your Password Must Have At Most " + Setting.PASSWORD_MAX_LENGTH + "  characters");
                        System.out.print(CommandColors.ANSI_RESET);
                        continue;
                    }

                    System.out.println("Repeat Your Password");
                    String repeatedPassword = scanner.nextLine();

                    if (password.equals(repeatedPassword)) {
                        return password;
                    } else {
                        System.out.println(CommandColors.ANSI_RED + "Your Passwords Dont Match.Please Try Again.");
                        System.out.print(CommandColors.ANSI_RESET);
                    }
                } else {
                    password = old;
                    return password;
                }


            }
        }


    }

    public static String createEmailForm(Scanner scanner, String old, boolean required) throws Exception {
        String email = null;
        while (true) {
            if (old == null && required) {
                System.out.println("Enter Your Email :");
                email = scanner.nextLine();
                if (email.trim().equals(".")) {
                    System.out.println(CommandColors.ANSI_RED + "You Cant Choose ((.)) For Your Email");
                    System.out.print(CommandColors.ANSI_RESET);
                    continue;
                }
                if (!DataUtility.isStringCorrectEmail(email)){
                    System.out.println(CommandColors.ANSI_RED + "Your FirstName Format IS Invalid.\nYou can only use a-z A-Z 0-9 _ @ .");
                    System.out.print(CommandColors.ANSI_RESET);
                    continue;
                }
                if (!email.contains("@")){
                    System.out.println(CommandColors.ANSI_RED + "Email Format Is Invalid");
                    System.out.print(CommandColors.ANSI_RESET);
                    continue;
                }
            } else if (old != null && !required) {
                System.out.println(CommandColors.ANSI_BLUE + old);
                System.out.print(CommandColors.ANSI_RESET);
                System.out.println("Enter Your New Email :(Or If You Dont Want Please Type ((.)) )");
                email = scanner.nextLine();
                if(email.trim().equals(".")){
                    return old;
                }
                if (!DataUtility.isStringCorrectEmail(email)){
                    System.out.println(CommandColors.ANSI_RED + "Your FirstName Format IS Invalid.\nYou can only use a-z A-Z 0-9 _ @ .");
                    System.out.print(CommandColors.ANSI_RESET);
                    continue;
                }
                if (!email.contains("@")){
                    System.out.println(CommandColors.ANSI_RED + "Email Format Is Invalid");
                    System.out.print(CommandColors.ANSI_RESET);
                    continue;
                }
            } else if (old == null && !required) {

            } else if (old != null && required) {

            }
            if (!Account.isEmailExists(email)) {
                return email;
            } else {
                System.out.println(CommandColors.ANSI_RED + "Email is already exists");
                System.out.print(CommandColors.ANSI_RESET);
            }

        }
    }

    public static String createUsernameForm(Scanner scanner, String old, boolean required) throws Exception {
        String username = null;
        while (true) {
            if (old == null && required) {
                System.out.println("Enter Username :");
                username = scanner.nextLine();
                if (username.trim().equals(".")) {
                    System.out.println(CommandColors.ANSI_RED + "You Cant Choose ((.)) For Your Username");
                    System.out.print(CommandColors.ANSI_RESET);
                    continue;
                }
                if(!DataUtility.isStringOnlyAlphabetOrNumber(username)){
                    System.out.println(CommandColors.ANSI_RED + "Your FirstName Format IS Invalid.\nYou can only use a-z A-Z 0-9 _");
                    System.out.print(CommandColors.ANSI_RESET);
                    continue;
                }
            } else if (old != null && !required) {
                System.out.println(CommandColors.ANSI_BLUE + old);
                System.out.print(CommandColors.ANSI_RESET);
                System.out.println("Enter Your New Username :(Or If You Dont Want Please Type ((.)) )");
                username = scanner.nextLine();


                if (username.trim().equals(".")) {
                    return old;
                }

                if(!DataUtility.isStringOnlyAlphabetOrNumber(username)){
                    System.out.println(CommandColors.ANSI_RED + "Your FirstName Format IS Invalid.\nYou can only use a-z A-Z 0-9 _");
                    System.out.print(CommandColors.ANSI_RESET);
                    continue;
                }
            } else if (old == null && !required) {

            } else if (old != null && required) {





            }

            if (!Account.isUsernameExists(username)) {
                return username;
            } else {
                System.out.println(CommandColors.ANSI_RED + "username is already exists");
                System.out.print(CommandColors.ANSI_RESET);
            }

        }
    }

    public static String createForgotPasswordAnswerForm(Scanner scanner, String old, boolean required) {
        String forgotPasswordAnswer = null;
        while (true) {
            if (old == null && required) {
                System.out.println("Enter the Answer of Your Forget Password :");
                forgotPasswordAnswer = scanner.nextLine();
                if (forgotPasswordAnswer.trim().equals(".")) {
                    System.out.println(CommandColors.ANSI_RED + "You Cant Choose ((.)) For The Answer of Your Forget Password :");
                    System.out.print(CommandColors.ANSI_RESET);
                    continue;
                }
                if (!DataUtility.isStringOnlyAlphabetOrNumber(forgotPasswordAnswer)){
                    System.out.println(CommandColors.ANSI_RED + "Your FirstName Format IS Invalid.\nYou can only use a-z A-Z 0-9 _");
                    System.out.print(CommandColors.ANSI_RESET);
                    continue;
                }
            } else if (old != null && !required) {
                System.out.println(CommandColors.ANSI_BLUE + old);
                System.out.print(CommandColors.ANSI_RESET);
                System.out.println("Enter The New Answer of Your Forget Password :(Or If You Dont Want Please Type ((.)) )");
                forgotPasswordAnswer = scanner.nextLine();
                if (forgotPasswordAnswer.trim().equals(".")){
                    return old;
                }
                if (!DataUtility.isStringOnlyAlphabetOrNumber(forgotPasswordAnswer)){
                    System.out.println(CommandColors.ANSI_RED + "Your FirstName Format IS Invalid.\nYou can only use a-z A-Z 0-9 _");
                    System.out.print(CommandColors.ANSI_RESET);
                    continue;
                }
            } else if (old == null && !required) {

            } else if (old != null && required) {

            }
            return forgotPasswordAnswer;
        }
    }

}
