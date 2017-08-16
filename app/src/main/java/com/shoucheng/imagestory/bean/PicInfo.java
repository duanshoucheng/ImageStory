package com.shoucheng.imagestory.bean;

/**
 * Created by Administrator on 17-8-16.
 */

public class PicInfo {
    private String picUrl;
    private String info;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "picUrl={" + picUrl + "}; info={" + info + "}";
    }
}
