package com.company.global;

import com.company.CustomArrayList;
import com.company.model.Post;

public class Temp {
    public  static CustomArrayList<Post> images = new CustomArrayList<>(Post::new);
    public  static CustomArrayList<Post> videos = new CustomArrayList<>(Post::new);
    public  static CustomArrayList<Post> audios = new CustomArrayList<>(Post::new);
    public  static CustomArrayList<Post> texts = new CustomArrayList<>(Post::new);


}
