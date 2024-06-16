package com.appzeto.status.insatdownload.instagram_model;

import androidx.annotation.Keep;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Keep
public class ModelResponse implements Serializable {

    @SerializedName("data")
    public ModelGraphshortcode modelGraphshortcode;

    public ModelGraphshortcode getModelGraphshortcode() {
        return modelGraphshortcode;
    }

    public void setModelGraphshortcode(ModelGraphshortcode modelGraphshortcode) {
        this.modelGraphshortcode = modelGraphshortcode;
    }
}
