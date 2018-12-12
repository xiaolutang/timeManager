package com.txl.time_manager.data.source.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.txl.time_manager.data.TimeStatistics;
import com.txl.time_manager.data.source.local.dao.ITaskDao;
import com.txl.time_manager.data.source.local.dao.ITimeStatisticsDao;
import com.txl.time_manager.data.task.Task;

/**
 * Copyright (c) 2018, 唐小陆 All rights reserved.
 * author：txl
 * date：2018/8/26
 * description：
 */
@Database(entities = {TimeStatistics.class, Task.class}, version = 1, exportSchema = false)
public abstract class TimeManagerDatabase extends RoomDatabase {
    private static TimeManagerDatabase instance;

    private static final Object sLock = new Object();

    public static TimeManagerDatabase getInstance(Context context){
        synchronized (sLock) {
            if(instance == null){
                instance = Room.databaseBuilder( context.getApplicationContext(), TimeManagerDatabase.class, "TimeManagerDatabase.db").build();
            }
            return instance;
        }
    }

    public abstract ITimeStatisticsDao getTimeStatisticsDao();

    public abstract ITaskDao getTaskDao();

}
