package com.txl.timemanager.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Copyright (c) 2018, 唐小陆 All rights reserved.
 * author：txl
 * date：2018/8/26
 * description：时间统计分析表
 */
@Entity(tableName = "time_statistics")
public class TimeStatistics {

    @PrimaryKey
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo
    private String date;
    @ColumnInfo
    private String time_7;
    @ColumnInfo
    private String time_8;
    @ColumnInfo
    private String time_9;
    @ColumnInfo
    private String time_10;
    @ColumnInfo
    private String time_11;
    @ColumnInfo
    private String time_12;
    @ColumnInfo
    private String time_13;
    @ColumnInfo
    private String time_14;
    @ColumnInfo
    private String time_15;
    @ColumnInfo
    private String time_16;
    @ColumnInfo
    private String time_17;
    @ColumnInfo
    private String time_18;
    @ColumnInfo
    private String time_19;
    @ColumnInfo
    private String time_20;
    @ColumnInfo
    private String time_21;
    @ColumnInfo
    private String time_22;
    @ColumnInfo
    private String time_23;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime_7() {
        return time_7;
    }

    public void setTime_7(String time_7) {
        this.time_7 = time_7;
    }

    public String getTime_8() {
        return time_8;
    }

    public void setTime_8(String time_8) {
        this.time_8 = time_8;
    }

    public String getTime_9() {
        return time_9;
    }

    public void setTime_9(String time_9) {
        this.time_9 = time_9;
    }

    public String getTime_10() {
        return time_10;
    }

    public void setTime_10(String time_10) {
        this.time_10 = time_10;
    }

    public String getTime_11() {
        return time_11;
    }

    public void setTime_11(String time_11) {
        this.time_11 = time_11;
    }

    public String getTime_12() {
        return time_12;
    }

    public void setTime_12(String time_12) {
        this.time_12 = time_12;
    }

    public String getTime_13() {
        return time_13;
    }

    public void setTime_13(String time_13) {
        this.time_13 = time_13;
    }

    public String getTime_14() {
        return time_14;
    }

    public void setTime_14(String time_14) {
        this.time_14 = time_14;
    }

    public String getTime_15() {
        return time_15;
    }

    public void setTime_15(String time_15) {
        this.time_15 = time_15;
    }

    public String getTime_16() {
        return time_16;
    }

    public void setTime_16(String time_16) {
        this.time_16 = time_16;
    }

    public String getTime_17() {
        return time_17;
    }

    public void setTime_17(String time_17) {
        this.time_17 = time_17;
    }

    public String getTime_18() {
        return time_18;
    }

    public void setTime_18(String time_18) {
        this.time_18 = time_18;
    }

    public String getTime_19() {
        return time_19;
    }

    public void setTime_19(String time_19) {
        this.time_19 = time_19;
    }

    public String getTime_20() {
        return time_20;
    }

    public void setTime_20(String time_20) {
        this.time_20 = time_20;
    }

    public String getTime_21() {
        return time_21;
    }

    public void setTime_21(String time_21) {
        this.time_21 = time_21;
    }

    public String getTime_22() {
        return time_22;
    }

    public void setTime_22(String time_22) {
        this.time_22 = time_22;
    }

    public String getTime_23() {
        return time_23;
    }

    public void setTime_23(String time_23) {
        this.time_23 = time_23;
    }

    @Ignore
    public TimeStatistics() {
    }

    public TimeStatistics(int id, String date, String time_7, String time_8, String time_9, String time_10, String time_11, String time_12, String time_13, String time_14, String time_15, String time_16, String time_17, String time_18, String time_19, String time_20, String time_21, String time_22, String time_23) {
        this.id = id;
        this.date = date;
        this.time_7 = time_7;
        this.time_8 = time_8;
        this.time_9 = time_9;
        this.time_10 = time_10;
        this.time_11 = time_11;
        this.time_12 = time_12;
        this.time_13 = time_13;
        this.time_14 = time_14;
        this.time_15 = time_15;
        this.time_16 = time_16;
        this.time_17 = time_17;
        this.time_18 = time_18;
        this.time_19 = time_19;
        this.time_20 = time_20;
        this.time_21 = time_21;
        this.time_22 = time_22;
        this.time_23 = time_23;
    }
}
