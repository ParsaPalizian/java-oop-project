package com.company.utility;

import com.company.gui.assets.GroupItem;
import com.company.gui.configuration.GuiSetting;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileUtility {

    public static String copyPostFile(String path) throws IOException {
        File src = new File(path);
        String destName = System.nanoTime() + "." + path.substring(path.lastIndexOf('.') + 1);
        String destPath = "assets\\posts\\" + destName;
        File dest = new File(destPath);
//        System.out.println(dest.toPath());
        Files.copy(src.toPath(), dest.toPath());

        return destName;
    }

    public static String copyAvatarImage(String path) throws IOException {
        File src = new File(path);
        String destName = System.nanoTime() + "." + path.substring(path.lastIndexOf('.') + 1);
        String destPath = "assets\\profiles\\" + destName;
        File dest = new File(destPath);
//        System.out.println(dest.toPath());
        Files.copy(src.toPath(), dest.toPath());
        return destName;
    }

    public static String copyGroupAvatarImage(String path) throws IOException {
        File src = new File(path);
        String destName = System.nanoTime() + "." + path.substring(path.lastIndexOf('.') + 1);
        String destPath = "assets\\groups\\profiles\\" + destName;
        File dest = new File(destPath);
//        System.out.println(dest.toPath());
        Files.copy(src.toPath(), dest.toPath());
        return destName;
    }


    public static boolean isAvatarExists(String fileName) {
        return new File("assets\\profiles\\" + fileName).exists();
    }


}
