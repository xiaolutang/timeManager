package com.txl.timemanager.data.source.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.txl.timemanager.data.task.Task;

import java.util.List;

/**
 * Copyright (c) 2018, 唐小陆 All rights reserved.
 * author：txl
 * date：2018/11/26
 * description：任务表的操作
 */
@Dao
public interface ITaskDao {
    @Query( "select * from task" )
    List<Task> getTask();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addTask(Task task);

    @Update
    int updateTask(Task task);

    @Query("DELETE FROM task WHERE task_id = :task_id")
    int deleteTaskDate(int task_id);
}
