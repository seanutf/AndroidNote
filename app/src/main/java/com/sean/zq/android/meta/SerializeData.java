package com.sean.zq.android.meta;

import android.os.Parcel;
import android.os.Parcelable;

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

    public SerializeData(){}

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
        in.readStringList(hobby);
        in.readTypedList(addrDataList, AddrData.CREATOR);
        mDataPattern = DataPattern.values()[in.readInt()];
        in.readMap(score, getClass().getClassLoader());
    }
}
