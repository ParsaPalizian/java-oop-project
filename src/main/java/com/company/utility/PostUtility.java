package com.company.utility;

import com.company.CustomArrayList;
import com.company.enums.MediaTypes;
import com.company.model.Post;

public class PostUtility {


    public static CustomArrayList<Post> getImagePosts(CustomArrayList<Post> posts) {


        CustomArrayList<Post> fn = new CustomArrayList<>(Post::new);
        for (Post post : posts) {
            for (String string : MediaTypes.IMAGE_TYPES) {
                if (post.getMedia().endsWith(string)) {
                    fn.add(post);
                }
            }
        }


        return fn;


    }

    public static CustomArrayList<Post> getVideosPosts(CustomArrayList<Post> posts) {


        CustomArrayList<Post> fn = new CustomArrayList<>(Post::new);
        for (Post post : posts) {
            for (String string : MediaTypes.VIDEO_TYPES) {
                if (post.getMedia().endsWith(string)) {
                    fn.add(post);
                }
            }
        }


        return fn;


    }

    public static CustomArrayList<Post> getAudiosPosts(CustomArrayList<Post> posts) {


        CustomArrayList<Post> fn = new CustomArrayList<>(Post::new);
        for (Post post : posts) {
            for (String string : MediaTypes.AUDIO_TYPES) {
                if (post.getMedia().endsWith(string)) {
                    fn.add(post);
                }
            }
        }


        return fn;


    }
    public static CustomArrayList<Post> getTextPosts(CustomArrayList<Post> posts) {


        CustomArrayList<Post> fn = new CustomArrayList<>(Post::new);
        for (Post post : posts) {

            if(post.getMedia()==null || post.getMedia().trim().equals("")){
                fn.add(post);
            }
        }

        return fn;

    }
}
