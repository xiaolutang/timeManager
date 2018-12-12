package com.txl.time_manager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2018, 唐小陆 All rights reserved.
 * author：txl
 * date：2018/9/16
 * description：
 */
public class PieChart extends View {

    private final String TAG = "PieChart";
    private List<String> titles;
    private List<Integer> percentTags;

    private Paint mPaint;

    public PieChart(Context context) {
        super( context );
    }

    public PieChart(Context context, @Nullable AttributeSet attrs) {
        super( context, attrs );
    }

    public PieChart(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super( context, attrs, defStyleAttr );
    }

    private void init(){
        titles = new ArrayList<>(  );
        titles.add( "高效工作" );
        titles.add( "浪费时间" );
        titles.add( "正真休息" );
        percentTags = new ArrayList<>(  );
        percentTags.add( 30 );
        percentTags.add( 40 );
        percentTags.add( 30 );
        mPaint = new Paint(  );
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw( canvas );
        for (Integer percent : percentTags){
            mPaint.setColor( Color.RED );
//            canvas.drawArc(  );
        }
    }



}
