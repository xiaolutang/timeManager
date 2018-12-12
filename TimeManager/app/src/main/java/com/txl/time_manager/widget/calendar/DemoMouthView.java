package com.txl.time_manager.widget.calendar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.MonthView;

/**
 * Copyright (c) 2018, 唐小陆 All rights reserved.
 * author：txl
 * date：2018/11/20
 * description：
 */
public class DemoMouthView extends MonthView {
    public DemoMouthView(Context context) {
        super( context );
    }

    @Override
    protected boolean onDrawSelected(Canvas canvas, Calendar calendar, int x, int y, boolean hasScheme) {
        return true;
    }

    @Override
    protected void onDrawScheme(Canvas canvas, Calendar calendar, int x, int y) {
        Paint paint = new Paint(  );
        paint.setColor( Color.RED );
        canvas.drawCircle( x,y,15, paint);
    }

    @Override
    protected void onDrawText(Canvas canvas, Calendar calendar, int x, int y, boolean hasScheme, boolean isSelected) {
        Paint paint = new Paint(  );
        paint.setColor( Color.RED );
        canvas.drawText( "aaa",x,y,paint );
    }
}
