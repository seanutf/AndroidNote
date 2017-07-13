package com.sean.zq.android.meta;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sks on 2017/7/13.
 */

public class AddrData implements Parcelable{

    String city;
    String area;
    String street;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(city);
        dest.writeString(area);
        dest.writeString(street);
    }

    public static final Parcelable.Creator<AddrData> CREATOR
            = new Parcelable.Creator<AddrData>() {
        public AddrData createFromParcel(Parcel in) {
            return new AddrData(in);
        }

        public AddrData[] newArray(int size) {
            return new AddrData[size];
        }
    };

    private AddrData(Parcel in) {
        city = in.readString();
        area = in.readString();
        street = in.readString();
    }
}
