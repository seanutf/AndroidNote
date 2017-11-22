package com.sean.zq.android.meta;

/**
 * Created by sean on 2016/9/6.
 */
public class MainData {
    String text;
    MainDataType type;
    String  summary;

    public MainData(String text, MainDataType type, String  summary){
        this.text = text;
        this.type = type;
        this.summary = summary;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public MainDataType getType() {
        return type;
    }

    public void setType(MainDataType type) {
        this.type = type;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public enum MainDataType{
        qa,
        view,
        layout,
        launch,
        thread,
        animation,
        share,
        permission,
        serialize,
        image,
    }
}
