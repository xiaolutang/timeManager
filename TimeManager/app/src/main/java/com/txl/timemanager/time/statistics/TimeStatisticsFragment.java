package com.txl.timemanager.time.statistics;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarLayout;
import com.haibin.calendarview.CalendarView;
import com.txl.time_manager.R;
import com.txl.timemanager.base.BaseFragment;
import com.txl.timemanager.widget.calendar.group.GroupRecyclerView;

/**
 * Copyright (c) 2018, 唐小陆 All rights reserved.
 * author：txl
 * date：2018/8/26
 * description：
 */
public class TimeStatisticsFragment extends BaseFragment implements CalendarView.OnCalendarSelectListener, CalendarView.OnYearChangeListener {
    private static final String TAG = TimeStatisticsFragment.class.getSimpleName();
    private TextView mTextMonthDay;

    private TextView mTextYear;

    private TextView mTextLunar;

    private TextView mTextCurrentDay;

    private CalendarView mCalendarView;

    private RelativeLayout mRelativeTool;
    private int mYear;
    private CalendarLayout mCalendarLayout;
    private GroupRecyclerView mRecyclerView;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d( TAG,"onCreateView" );
        ViewGroup rootView = (ViewGroup) inflater.inflate( R.layout.time_ststistics_fragment,container,false );
        initView(rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d( TAG,"onViewCreated" );
        super.onViewCreated( view, savedInstanceState );

    }

    private void initView(View rootView){
        mTextMonthDay = rootView.findViewById(R.id.tv_month_day);
        mTextYear = rootView. findViewById(R.id.tv_year);
        mTextLunar = rootView.findViewById(R.id.tv_lunar);
        mRelativeTool = rootView.findViewById(R.id.rl_tool);
        mCalendarView = rootView.findViewById(R.id.calendarView);
        mTextCurrentDay = rootView.findViewById(R.id.tv_current_day);
        mTextMonthDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mCalendarLayout.isExpand()) {
                    mCalendarView.showYearSelectLayout(mYear);
                    return;
                }
                mCalendarView.showYearSelectLayout(mYear);
                mTextLunar.setVisibility(View.GONE);
                mTextYear.setVisibility(View.GONE);
                mTextMonthDay.setText(String.valueOf(mYear));
            }
        });
        rootView.findViewById(R.id.fl_current).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCalendarView.scrollToCurrent();
            }
        });
        mCalendarLayout = rootView.findViewById(R.id.calendarLayout);
        mCalendarView.setOnCalendarSelectListener(this);
        mCalendarView.setOnYearChangeListener(this);
        mTextYear.setText(String.valueOf(mCalendarView.getCurYear()));
        mYear = mCalendarView.getCurYear();
        mTextMonthDay.setText(mCalendarView.getCurMonth() + "月" + mCalendarView.getCurDay() + "日");
        mTextLunar.setText("今日");
        mTextCurrentDay.setText(String.valueOf(mCalendarView.getCurDay()));
    }

    @Override
    public void onCalendarOutOfRange(Calendar calendar) {

    }

    @Override
    public void onCalendarSelect(Calendar calendar, boolean isClick) {
        mTextLunar.setVisibility(View.VISIBLE);
        mTextYear.setVisibility(View.VISIBLE);
        mTextMonthDay.setText(calendar.getMonth() + "月" + calendar.getDay() + "日");
        mTextYear.setText(String.valueOf(calendar.getYear()));
        mTextLunar.setText(calendar.getLunar());
        mYear = calendar.getYear();
    }

    @Override
    public void onYearChange(int year) {
        mTextMonthDay.setText(String.valueOf(year));
    }
}
