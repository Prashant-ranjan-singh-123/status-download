package com.appzeto.status.insatdownload.instagram_model;

import androidx.annotation.Keep;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Keep
public class ModelGraphshortcode implements Serializable {

    @SerializedName("shortcode_media")
    public ModelInstagramshortMediacode shortcode_media;

    public ModelInstagramshortMediacode getShortcode_media() {
        return shortcode_media;
    }

    public void setShortcode_media(ModelInstagramshortMediacode shortcode_media) {
        this.shortcode_media = shortcode_media;
    }
}
