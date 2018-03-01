package com.sean.zq.android.module.data.serialize.meta;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sean on 2017/7/13.
 * 一个简单的数据示例，用于android中的数据序列化
 */

public class SerializeData implements Parcelable{
    String name;
    long id;
    int postion;
    List<String> hobby;
    List<AddrData> addrDataList;
    float height;
    double weight;
    DataPattern mDataPattern;
    Map<Integer, String> score;
    AddrData first;
    OtherUserData otherUserData;
    boolean isFirst;
    boolean isChina;

    public SerializeData(){}

    public static class Builder{
        String name;
        long id;
        int postion;
        List<String> hobby;
        List<AddrData> addrDataList;
        float height;
        double weight;
        DataPattern mDataPattern;
        Map<Integer, String> score;
        AddrData first;
        OtherUserData otherUserData;
        boolean isFirst;
        boolean isChina;
        public Builder(){}

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setPostion(int postion) {
            this.postion = postion;
            return this;
        }

        public Builder setHobby(List<String> hobby) {
            this.hobby = hobby;
            return this;
        }

        public Builder setAddrDataList(List<AddrData> addrDataList) {
            this.addrDataList = addrDataList;
            return this;
        }

        public Builder setHeight(float height) {
            this.height = height;
            return this;
        }

        public Builder setmDataPattern(DataPattern mDataPattern) {
            this.mDataPattern = mDataPattern;
            return this;
        }

        public Builder setWeight(double weight) {
            this.weight = weight;
            return this;
        }

        public Builder setScore(Map<Integer, String> score) {
            this.score = score;
            return this;
        }

        public Builder setFirst(AddrData first) {
            this.first = first;
            return this;
        }

        public Builder setOtherUserData(OtherUserData otherUserData) {
            this.otherUserData = otherUserData;
            return this;
        }

        public Builder setFirst(boolean first) {
            isFirst = first;
            return this;
        }

        public Builder setChina(boolean china) {
            isChina = china;
            return this;
        }

        public SerializeData build(){
            return new SerializeData(this);
        }
    }

    private SerializeData(Builder builder){
        this.name = builder.name;
        this.id = builder.id;
        this.postion = builder.postion;
        this.hobby = builder.hobby;
        this.addrDataList = builder.addrDataList;
        this.height = builder.height;
        this.weight = builder.weight;
        this.mDataPattern = builder.mDataPattern;
        this.score = builder.score;
        this.first = builder.first;
        this.otherUserData = builder.otherUserData;
        this.isFirst = builder.isFirst;
        this.isChina = builder.isChina;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPostion() {
        return postion;
    }

    public void setPostion(int postion) {
        this.postion = postion;
    }

    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }

    public List<AddrData> getAddrDataList() {
        return addrDataList;
    }

    public void setAddrDataList(List<AddrData> addrDataList) {
        this.addrDataList = addrDataList;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public DataPattern getmDataPattern() {
        return mDataPattern;
    }

    public void setmDataPattern(DataPattern mDataPattern) {
        this.mDataPattern = mDataPattern;
    }

    public Map<Integer, String> getScore() {
        return score;
    }

    public void setScore(Map<Integer, String> score) {
        this.score = score;
    }

    public AddrData getFirst() {
        return first;
    }

    public void setFirst(AddrData first) {
        this.first = first;
    }

    public OtherUserData getOtherUserData() {
        return otherUserData;
    }

    public void setOtherUserData(OtherUserData otherUserData) {
        this.otherUserData = otherUserData;
    }

    public boolean isFirst() {
        return isFirst;
    }

    public void setFirst(boolean first) {
        isFirst = first;
    }

    public boolean isChina() {
        return isChina;
    }

    public void setChina(boolean china) {
        isChina = china;
    }

    public enum DataPattern {
        File,
        RANDOM,
        PREDEFINED,
        CUSTOMIZED
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(height);
        dest.writeDouble(weight);
        dest.writeInt(postion);
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeParcelable(first, flags);
        dest.writeSerializable(otherUserData);
        dest.writeStringList(hobby);
        dest.writeTypedList(addrDataList);
        dest.writeInt(mDataPattern.ordinal());
        dest.writeMap(score);
        boolean[] booleanList = {isFirst, isChina};
        dest.writeBooleanArray(booleanList);
    }

    public static final Parcelable.Creator<SerializeData> CREATOR
            = new Parcelable.Creator<SerializeData>() {
        public SerializeData createFromParcel(Parcel in) {
            return new SerializeData(in);
        }

        public SerializeData[] newArray(int size) {
            return new SerializeData[size];
        }
    };

    private SerializeData(Parcel in) {
        height = in.readFloat();
        weight = in.readDouble();
        postion = in.readInt();
        id = in.readLong();
        name = in.readString();
        first = in.readParcelable(AddrData.class.getClassLoader());
        otherUserData = (OtherUserData) in.readSerializable();
        hobby = new ArrayList<String>();
        in.readStringList(hobby);
        addrDataList = new ArrayList<AddrData>();
        in.readTypedList(addrDataList, AddrData.CREATOR);
        mDataPattern = DataPattern.values()[in.readInt()];
        score = new HashMap<Integer, String>();
        in.readMap(score, getClass().getClassLoader());
        boolean[] booleanList = {isFirst, isChina};
        in.readBooleanArray(booleanList);
    }
}
