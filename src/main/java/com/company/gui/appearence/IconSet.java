package com.company.gui.appearence;

import org.kordamp.ikonli.Ikon;

/**
 * Created by kami on 7/29/2022.
 */
public class IconSet {

    public Main main;
    public Home home;
    public Theme theme;
    public Search search;
    public Action action;

    {
        main = new Main();
        home = new Home();
        theme = new Theme();
        search = new Search();
        action = new Action();
    }

    public class Main {
        public Ikon hamburgerMenu;
        public Ikon defaultAvatar;
        public Ikon home;
        public Ikon timeline;
        public Ikon explorer;
        public Ikon search;
        public Ikon settings;
        public Ikon login;
        public Ikon register;
        public Ikon forgot;
        public Ikon logout;

    }

    public class Home {
        public Ikon profilePictures;
        public Ikon newPost;
        public Ikon followers;
        public Ikon followings;
        public Ikon posts;
        public Ikon images;
        public Ikon videos;
        public Ikon audios;
        public Ikon texts;
        public Ikon groups;
        public Ikon messages;
        public Ikon blobks;
        public Ikon requests;
        public Ikon recommends;
    }


    public class Search {

        public Ikon search;
        public Ikon viewHistory;
        public Ikon clear;

    }


    public class Theme {
        public Ikon changeColor;
        public Ikon changeTheme;
    }



    public class Action {
        public Ikon unblock;
        public Ikon followBack;
        public Ikon block;
        public Ikon unfollow;
        public Ikon accept;
        public Ikon reject;
        public Ikon request;
        public Ikon add;
        public Ikon back;
        public Ikon save;
        public Ikon remove;
        public Ikon changeAvatar;

    }

}
