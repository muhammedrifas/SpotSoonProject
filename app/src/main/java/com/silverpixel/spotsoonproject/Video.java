package com.silverpixel.spotsoonproject;

/**
 * Created by Rifas on 6/13/2017.
 */

public class Video {
    private String title,time,desc;
    int image_url;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImage_url() {
        return image_url;
    }

    public void setImage_url(int image_url) {
        this.image_url = image_url;
    }

    public Video() {
    }
    public Video(String title,String time,String desc,int image_url) {
        this.title=title;
        this.time=time;
        this.desc=desc;
        this.image_url=image_url;
    }
}
