package com.dummyapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by cl-macmini-86 on 3/30/17.
 */

public  class ABC implements Parcelable {
    String fNmae;
    String lNmae;
    final static int  i;

    static {
        i=8;
    }


    public String getfNmae() {
        return fNmae;
    }

    public void setfNmae(String fNmae) {
        this.fNmae = fNmae;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.fNmae);
        dest.writeString(this.lNmae);
    }

    public int ABC() {
      return 0;
    }

    protected ABC(Parcel in) {
        this.fNmae = in.readString();
        this.lNmae = in.readString();
    }

    public static final Parcelable.Creator<ABC> CREATOR = new Parcelable.Creator<ABC>() {
        @Override
        public ABC createFromParcel(Parcel source) {
            return new ABC(source);
        }

        @Override
        public ABC[] newArray(int size) {
            return new ABC[size];
        }
    };
}
