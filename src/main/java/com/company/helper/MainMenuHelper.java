package com.company.helper;

import com.company.Result;
import com.company.dataadapter.PostDataAdapter;
import com.company.enums.CommandColors;
import com.company.enums.MenuLevel;
import com.company.enums.RoleType;
import com.company.global.Globals;
import com.company.launcher.Main;
import com.company.model.Account;
import com.company.ui.AccountUI;
import com.company.utility.PrintUtility;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Locale;

public class MainMenuHelper {
    public static void printMain() {
        System.out.println("MAIN MENU");
        PrintUtility.printlnMenus(PrintUtility.createMainMenu(RoleType.OWNER));
    }

    public static void performMainCommand(String command) throws SQLException, ParseException {
        try {
            int intComm = Integer.parseInt(command);
            switch (intComm) {

                case 1:
                    Globals.menuLevels.push(MenuLevel.HOME);
                    break;
                case 2:
                    PostDataAdapter adapter = new PostDataAdapter();
                    Globals.currentPosts = adapter.find(Globals.currentAccount.getId());
                    Globals.menuLevels.push(MenuLevel.TIMELINE);
                    break;

                case 3:
                    Globals.menuLevels.push(MenuLevel.EXPLORER);
                    break;

                case 4:
                    Globals.menuLevels.push(MenuLevel.SEARCH);
                    break;

                case 5:
                    System.out.println(CommandColors.ANSI_YELLOW + "UserName : " + CommandColors.ANSI_CYAN + Globals.currentAccount.getUserName());
                    System.out.println(CommandColors.ANSI_YELLOW + "First Name : " + Globals.currentAccount.getFirstName());
                    System.out.println(CommandColors.ANSI_YELLOW + "Last Name : " + Globals.currentAccount.getLastName());
                    System.out.println(CommandColors.ANSI_YELLOW + "PhoneNumber : " + Globals.currentAccount.getPhoneNumber());
                    System.out.println(CommandColors.ANSI_YELLOW + "Email : " + Globals.currentAccount.getEmail());
                    System.out.println(CommandColors.ANSI_YELLOW + "Birthday : " + Globals.currentAccount.getBirthday());
                    System.out.println(CommandColors.ANSI_YELLOW + "Bio : " + Globals.currentAccount.getBio());
                    System.out.print(CommandColors.ANSI_RESET);
                    break;

                case 6:
                    String username = AccountUI.createUsernameForm(Main.scanner, Globals.currentAccount.getUserName(), false);
                    String password = AccountUI.createPasswordForm(Main.scanner, Globals.currentAccount.getPassword(), false);
                    String firstName = AccountUI.createFirstNameForm(Main.scanner, Globals.currentAccount.getFirstName(), false);
                    String lastName = AccountUI.createLastNameForm(Main.scanner, Globals.currentAccount.getLastName(), false);
                    String phoneNumber = AccountUI.createPhoneNumberForm(Main.scanner, Globals.currentAccount.getPhoneNumber(), false);
                    String email = AccountUI.createEmailForm(Main.scanner, Globals.currentAccount.getEmail(), false);
                    LocalDate birthday = AccountUI.createBirthdayForm(Main.scanner, Globals.currentAccount.getBirthday(), false);
                    String bio = AccountUI.createBioForm(Main.scanner, Globals.currentAccount.getBio(), false);
                    Result result = Globals.currentAccount.editProfile(username, password, firstName, lastName, phoneNumber, email, birthday, bio);
                    if (!result.isError()) {
                        PrintUtility.printlnSuccess("Edit SUCCESSFUL");
                    } else {
                        PrintUtility.printlnFail("Error Raised");
                    }
                    break;

                case 7:
                    System.out.println("Are You Sure You want To Change Your Account Type?");
                    System.out.println("(Y)es Or (N)o");

                    String yesOrNo1 = Main.scanner.nextLine();
                    switch (yesOrNo1.toUpperCase(Locale.ROOT)) {
                        case "Y":
                            Globals.currentAccount.setBusiness(!Globals.currentAccount.isBusiness());
                            Account.updateIsBusiness(Globals.currentAccount);
                            System.out.println(CommandColors.ANSI_BLUE + "You Have Changed Your Account Type.Login Again");
                            System.out.print(CommandColors.ANSI_RESET);
                            Globals.menuLevels.pop();
                            Globals.menuLevels.push(MenuLevel.LOGIN);
                            break;
                    }
                    break;
                case 8:
                    System.out.println("Are You Sure You want To Change Your Private Or Open Account Type?");
                    System.out.println("(Y)es Or (N)o");

                    String yesOrNo2 = Main.scanner.nextLine();
                    switch (yesOrNo2.toUpperCase(Locale.ROOT)) {
                        case "Y":
                            Globals.currentAccount.setPrivate(!Globals.currentAccount.isPrivate());
                            Account.updateIsPrivate(Globals.currentAccount);
                            System.out.println(CommandColors.ANSI_BLUE + "You Have Changed Your Private Or Open Account Type.Login Again");
                            System.out.print(CommandColors.ANSI_RESET);
                            Globals.menuLevels.pop();
                            Globals.menuLevels.push(MenuLevel.LOGIN);
                            break;
                    }
                    break;

                case 0:
                    Globals.menuLevels.clear();
                    Globals.menuLevels.push(MenuLevel.LOGIN);

            }
        } catch (Exception ex) {
            PrintUtility.printlnFail("Please Enter Correct Number");
        }

    }

}
