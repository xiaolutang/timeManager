package com.txl.timemanager.data.task;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Copyright (c) 2018, 唐小陆 All rights reserved.
 * author：txl
 * date：2018/11/26
 * description：任务表
 */
@Entity(tableName = "task")
public class Task {

    @ColumnInfo
    private long completeDate;
    @ColumnInfo
    private String completeDateStr;
    @ColumnInfo
    private String content;
    @ColumnInfo
    private long date;
    @ColumnInfo
    private String dateStr;
    @ColumnInfo
    private int id;
    @ColumnInfo
    private int status;
    @ColumnInfo
    private String title;
    @ColumnInfo
    private int type;
    @ColumnInfo
    int userId;
    @PrimaryKey
    @ColumnInfo(name = "task_id")
    int taskId;

    @Ignore
    public Task() {
    }

    public Task(long completeDate, String completeDateStr, String content, long date, String dateStr, int id, int status, String title, int type, int userId, int taskId) {
        this.completeDate = completeDate;
        this.completeDateStr = completeDateStr;
        this.content = content;
        this.date = date;
        this.dateStr = dateStr;
        this.id = id;
        this.status = status;
        this.title = title;
        this.type = type;
        this.userId = userId;
        this.taskId = taskId;
    }

    public long getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(long completeDate) {
        this.completeDate = completeDate;
    }

    public String getCompleteDateStr() {
        return completeDateStr;
    }

    public void setCompleteDateStr(String completeDateStr) {
        this.completeDateStr = completeDateStr;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public String toString() {
        return "Task{" +
                "completeDate=" + completeDate +
                ", completeDateStr='" + completeDateStr + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", dateStr='" + dateStr + '\'' +
                ", id=" + id +
                ", status=" + status +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", userId=" + userId +
                ", taskId=" + taskId +
                '}';
    }
}
