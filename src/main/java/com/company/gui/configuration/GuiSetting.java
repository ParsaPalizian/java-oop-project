package com.company.gui.configuration;

import com.company.gui.appearence.IconSet;
import com.company.gui.appearence.Theme;
import org.kordamp.ikonli.dashicons.Dashicons;
import org.kordamp.ikonli.elusive.Elusive;
import org.kordamp.ikonli.entypo.Entypo;
import org.kordamp.ikonli.fontawesome5.FontAwesomeRegular;
import org.kordamp.ikonli.icomoon.Icomoon;
import org.kordamp.ikonli.ionicons.Ionicons;
import org.kordamp.ikonli.materialdesign.MaterialDesign;

import java.awt.*;

/**
 * Created by kami on 7/29/2022.
 */
public class GuiSetting {

    private static Theme darkTheme = null;
    private static Theme lightTheme = null;
    private static IconSet materialDesignIconSet = null;
    private static IconSet fontAwesomeIconSet = null;


    public static Theme selectedTheme = null;
    public static IconSet selectedIconSet = null;


    static {

        darkTheme = new Theme();
        darkTheme.setName("Dark");
        darkTheme.setPrimaryColor(new Color(2, 48, 71));
        darkTheme.setPrimaryVariantColor(new Color(54, 89, 115));
        darkTheme.setSecondaryColor(new Color(255, 183, 3));
        darkTheme.setSecondaryVariantColor(new Color(255, 233, 78));


        lightTheme = new Theme();
        lightTheme.setName("Light");
        lightTheme.setPrimaryColor(new Color(255, 183, 3));
        lightTheme.setPrimaryVariantColor(new Color(255, 233, 78));
        lightTheme.setSecondaryColor(new Color(2, 48, 71));
        lightTheme.setSecondaryVariantColor(new Color(54, 89, 115));


        materialDesignIconSet = new IconSet();
        materialDesignIconSet.main.hamburgerMenu = MaterialDesign.MDI_MENU;

        materialDesignIconSet.main.defaultAvatar = MaterialDesign.MDI_FACE_PROFILE;
        materialDesignIconSet.main.home = MaterialDesign.MDI_HOME;
        materialDesignIconSet.main.timeline = MaterialDesign.MDI_CHART_TIMELINE;
        materialDesignIconSet.main.explorer = MaterialDesign.MDI_INTERNET_EXPLORER;
        materialDesignIconSet.main.search = MaterialDesign.MDI_ACCOUNT_SEARCH;
        materialDesignIconSet.main.settings = MaterialDesign.MDI_SETTINGS;

        materialDesignIconSet.main.login = MaterialDesign.MDI_LOGIN;
        materialDesignIconSet.main.register = Entypo.ADD_USER;
        materialDesignIconSet.main.forgot = MaterialDesign.MDI_ACCOUNT_KEY;
        materialDesignIconSet.main.logout = MaterialDesign.MDI_LOGOUT;

        materialDesignIconSet.home.profilePictures = MaterialDesign.MDI_FACE_PROFILE;
        materialDesignIconSet.home.newPost = MaterialDesign.MDI_FILE_DOCUMENT;
        materialDesignIconSet.home.followers = Entypo.USERS;
        materialDesignIconSet.home.followings = Ionicons.ION_ANDROID_WALK;
        materialDesignIconSet.home.posts = MaterialDesign.MDI_FILE_DOCUMENT_BOX;
        materialDesignIconSet.home.images = MaterialDesign.MDI_FILE_IMAGE;
        materialDesignIconSet.home.videos = MaterialDesign.MDI_FILE_VIDEO;
        materialDesignIconSet.home.audios = MaterialDesign.MDI_FILE_MUSIC;
        materialDesignIconSet.home.texts = MaterialDesign.MDI_FILE_WORD;
        materialDesignIconSet.home.groups = Elusive.GROUP;
        materialDesignIconSet.home.messages = MaterialDesign.MDI_MESSAGE;
        materialDesignIconSet.home.blobks = MaterialDesign.MDI_BLOCK_HELPER;
        materialDesignIconSet.home.requests = Dashicons.LIST_VIEW;
        materialDesignIconSet.home.recommends = Icomoon.ICM_USER_PLUS;


        materialDesignIconSet.theme.changeColor = MaterialDesign.MDI_FORMAT_COLOR_FILL;
        materialDesignIconSet.theme.changeTheme = MaterialDesign.MDI_THEME_LIGHT_DARK;


        materialDesignIconSet.search.search = MaterialDesign.MDI_FORMAT_COLOR_FILL;
        materialDesignIconSet.search.viewHistory = MaterialDesign.MDI_FORMAT_COLOR_FILL;
        materialDesignIconSet.search.clear = MaterialDesign.MDI_FORMAT_COLOR_FILL;

        materialDesignIconSet.action.unblock = Dashicons.UNLOCK;
        materialDesignIconSet.action.followBack = FontAwesomeRegular.HANDSHAKE;
        materialDesignIconSet.action.block = Elusive.LOCK;
        materialDesignIconSet.action.unfollow = Icomoon.ICM_USER_MINUS;
        materialDesignIconSet.action.accept = Icomoon.ICM_USER_CHECK;
        materialDesignIconSet.action.reject = Entypo.REMOVE_USER;
        materialDesignIconSet.action.request = Entypo.HAND;
        materialDesignIconSet.action.add = Entypo.ADD_TO_LIST;
        materialDesignIconSet.action.back = Entypo.BACK;
        materialDesignIconSet.action.save = Entypo.SAVE;
        materialDesignIconSet.action.remove = MaterialDesign.MDI_ACCOUNT_REMOVE;


        fontAwesomeIconSet = new IconSet();
        fontAwesomeIconSet.main.hamburgerMenu = MaterialDesign.MDI_MENU;


        selectedTheme = darkTheme;
        selectedIconSet = materialDesignIconSet;
    }


    public static void changeTheme() {
        if (selectedTheme.getName().equals("Dark")) {
            selectedTheme = lightTheme;
        } else if (selectedTheme.getName().equals("Light")) {
            selectedTheme = darkTheme;
        }
    }

}
