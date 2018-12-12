package com.txl.time_manager.data.source.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;


import com.txl.time_manager.data.TimeStatistics;

import java.util.Date;
import java.util.List;

/**
 * Copyright (c) 2018, 唐小陆 All rights reserved.
 * author：txl
 * date：2018/8/26
 * description：
 */
@Dao
public interface ITimeStatisticsDao {
    @Query( "select * from time_statistics" )
    List<TimeStatistics> getTimeStatisticsList();

    @Query( "select * from time_statistics where date = :date" )
    TimeStatistics getTimeStatisticsByDate(String date);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTimeStatistics(TimeStatistics timeStatistics);

    @Update
    int updateTimeStatistics(TimeStatistics timeStatistics);

    @Query("DELETE FROM time_statistics WHERE date = :date")
    int deleteTaskDate(String date);

    @Query("DELETE FROM time_statistics")
    void deleteAllTimeStatistics();
}
