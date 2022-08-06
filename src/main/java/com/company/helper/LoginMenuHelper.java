package com.company.helper;

import com.company.Result;
import com.company.enums.CommandColors;
import com.company.enums.MenuLevel;
import com.company.global.Globals;
import com.company.launcher.Main;
import com.company.model.Account;
import com.company.ui.AccountUI;
import com.company.utility.PrintUtility;

import java.sql.SQLException;
import java.text.ParseException;

public class LoginMenuHelper {
    public static void printLogin() {
        PrintUtility.createLoginMenu();
    }

    public static void performLogInCommand(String command) throws SQLException, ParseException {

        try {
            int intComm = Integer.parseInt(command);
            switch (intComm) {
                case 1: {
                    while (true) {
                        System.out.println("enter username :");
                        String username = Main.scanner.nextLine();
                        System.out.println("enter password :");
                        String password = Main.scanner.nextLine();
                        Result<Account> result = Account.login(username, password);
                        if (result.isError()) {
                            System.out.println("jngbgfscdxa");
                            for (String alert : result.getAlerts()) {
                                System.out.println(alert);
                            }
                        } else {

                            Globals.menuLevels.pop();
                            Globals.menuLevels.push(MenuLevel.MAIN);
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    String firstName = AccountUI.createFirstNameForm(Main.scanner, null, true);
                    String lastName = AccountUI.createLastNameForm(Main.scanner, null, true);
                    String username = AccountUI.createUsernameForm(Main.scanner, null, true);
                    String password = AccountUI.createPasswordForm(Main.scanner, null, true);
                    String email = AccountUI.createEmailForm(Main.scanner, null, true);
                    String forgetPasswordAnswer = AccountUI.createForgotPasswordAnswerForm(Main.scanner, null, true);
                    Result result = Account.signUp(firstName, lastName, username, password, email, "Who was your first school teacher", forgetPasswordAnswer);


                    System.out.println(CommandColors.ANSI_BLUE + "REGISTER SUCCESSFUL");
                    System.out.print(CommandColors.ANSI_RESET);

                    break;
                }
                case 3: {
                    System.out.println("Enter Your UserName :");
                    String userName = Main.scanner.nextLine();
                    if (Account.findBaseOnUserName(userName).getData() != null) {


                        Globals.forgetAccount = (Account) Account.findBaseOnUserName(userName).getData();

                        while (true) {
                            System.out.println(Globals.forgetAccount.getForgetPasswordQuestion());
                            String forgetQuestionAnswer = Main.scanner.nextLine();

                            if (Globals.forgetAccount.getForgetPasswordAnswer().equals(forgetQuestionAnswer)) {
                                String password = AccountUI.createPasswordForm(Main.scanner, "", true);
                                Globals.forgetAccount.setPassword(password);
                                Account.updatePassword(Globals.forgetAccount);
                                break;
                            } else {
                                System.out.println("Wrong Answer");
                            }
                        }
                    } else {
                        System.out.println("There is No Account with This UserName");
                    }
                    break;
                }
                case 0: {

                    System.exit(0);
                    break;
                }
                default:
                    PrintUtility.printlnFail("Please Enter Correct Number");
                    break;
            }
        }catch (Exception ex) {
            PrintUtility.printlnFail("Please Enter Correct Number");
        }
    }



}
