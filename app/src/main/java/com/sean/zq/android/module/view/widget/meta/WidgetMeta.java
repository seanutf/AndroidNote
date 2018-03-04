package com.sean.zq.android.module.view.widget.meta;

/**
 * Created by sean on 2016/10/12.
 */
public class WidgetMeta {
    String text;
    WidgetMetaType type;

    public WidgetMeta(String text, WidgetMetaType type){
        this.text = text;
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public WidgetMetaType getType() {
        return type;
    }

    public void setType(WidgetMetaType type) {
        this.type = type;
    }

    public enum WidgetMetaType{
        tv,
        iv,
        btn,
        et,
        ibtn,
        lv,
        gv,
        sv,
        tb,
        ctl,
    }
}
