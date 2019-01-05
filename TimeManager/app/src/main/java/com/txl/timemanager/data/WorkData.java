package com.txl.timemanager.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Copyright (c) 2018, 唐小陆 All rights reserved.
 * author：txl
 * date：2018/9/15
 * description：
 */
public class WorkData implements Serializable, Parcelable {
    private int workTime;
    private int restTime;
    private int wasteTime;

    private static final long serialVersionUID = -7060210544600464481L;

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }

    public int getRestTime() {
        return restTime;
    }

    public void setRestTime(int restTime) {
        this.restTime = restTime;
    }

    public int getWasteTime() {
        return wasteTime;
    }

    public void setWasteTime(int wasteTime) {
        this.wasteTime = wasteTime;
    }

    public WorkData(){}

    protected WorkData(Parcel in) {
        workTime = in.readInt();
        wasteTime = in.readInt();
        restTime = in.readInt();
    }

    public static final Creator<WorkData> CREATOR = new Creator<WorkData>() {
        @Override
        public WorkData createFromParcel(Parcel in) {
            return new WorkData( in );
        }

        @Override
        public WorkData[] newArray(int size) {
            return new WorkData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt( workTime );
        dest.writeInt( wasteTime );
        dest.writeInt( restTime );
    }
}
