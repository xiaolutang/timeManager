package com.txl.timemanager.data.source;

import com.txl.timemanager.data.TimeStatistics;

import java.util.Date;
import java.util.List;

/**
 * Copyright (c) 2018, 唐小陆 All rights reserved.
 * author：txl
 * date：2018/8/26
 * description：
 */
public interface ITimeStatisticsDataSource {
    interface LoadTimeStatisticsListCallback {

        void onTasksLoaded(List<TimeStatistics> timeStatisticsList);

        void onDataNotAvailable();
    }

    interface GetTimeStatisticsCallback {

        void onTaskLoaded(TimeStatistics timeStatistics);

        void onDataNotAvailable();
    }

    void getTimeStatisticsList(LoadTimeStatisticsListCallback callback);

    void getTimeStatistics(Date date, GetTimeStatisticsCallback callback);

    void saveTimeStatistics(TimeStatistics timeStatistics);
}
