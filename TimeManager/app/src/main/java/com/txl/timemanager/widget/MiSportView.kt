package com.txl.timemanager.widget

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.view.View

class MiSportView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : View(context, attrs, defStyleAttr) {

    /**
     * 圆半径
     * */
    var radius = 200
    /**
     * 角度
     * */
    var angle = 0f



    var point:PointF = PointF()

    /**
     * 圆点画笔
     * */
    var pointPaint = Paint()

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        pointPaint.color = Color.BLUE
        pointPaint.strokeWidth = 15f
        ObjectAnimator.ofFloat(this,"angle",0F,360F)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        calculatePoint()
        canvas?.drawPoint(point.x,point.y,pointPaint)
    }

    fun calculatePoint():PointF{
        point.y = (radius * Math.sin(angle.toDouble())).toFloat()
        point.x = (radius * Math.cos(angle.toDouble())).toFloat()
        return point
    }
}