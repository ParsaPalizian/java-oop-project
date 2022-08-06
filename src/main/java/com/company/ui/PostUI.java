package com.company.ui;

import java.util.Scanner;

public class PostUI {
    public static String createMediaForm(Scanner scanner, String old, boolean required) {
        String media = null;
        while (true) {
            if (old == null && required) {
                System.out.println("Enter Your Media Address :");
                media=scanner.nextLine();
                if(media==null){
                    continue;
                }
            } else if (old != null && !required) {

            } else if (old == null && !required) {

            } else if (old != null && required) {

            }
            return media;
        }
    }

    public static String createContentForm(Scanner scanner, String old, boolean required) {

        String content = null;
        while (true) {
            if (old == null && required) {
                System.out.println("Enter Your content :");
                content=scanner.nextLine();
                if(content.equals(".")){
                    continue;
                }
            } else if (old != null && !required) {
                System.out.println("Enter Your New Content");
                content=scanner.nextLine();
            } else if (old == null && !required) {

            } else if (old != null && required) {

            }
            return content;
        }
    }
}