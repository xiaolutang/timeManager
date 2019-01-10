package com.txl.timemanager.widget

import android.content.Context
import android.graphics.*
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.txl.time_manager.R
import java.util.*

class MiSportView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : View(context, attrs, defStyleAttr) {

    var TAG = "MiSportView"

    /**
     * 圆半径
     * */
    var radius = 200F

    /**
     * 弧长
     * */
    var arcLength = 345

    /**
     * 角度
     * */
    var angle = 0f
        set(value){
            field = value
            invalidate()
        }

    /**
     * 旋转速度
     * */
    var speed = 3

    var random = Random()

    var point:PointF = PointF()

    /**
     * 圆点画笔
     * */
    var pointPaint = Paint()

    /**
     * 圆弧画笔
     * */
    var arcPaint = Paint()

    /**
     * 是否需要重置
     * */
    var needReset = true

    var cannel = false

    /**
     *圆环数量
     */
    var linearArc = 15
    var arcS = mutableListOf<FireWorksCircle>()

    var centerPoint = PointF()

    var runnable :Runnable =object: Runnable {
        override fun run() {
            invalidate()
            nextState()
            if(!cannel) postDelayed(this,16)
        }
    }

    constructor(context:Context) :this(context,null,0)

    constructor(context: Context,attrs: AttributeSet?):this(context,attrs,0)

    private fun init() {
        centerPoint.x = width/2F
        centerPoint.y = height/2F

        radius = if(width>height) height/2F else width/2F
        pointPaint.color = Color.RED
        pointPaint.strokeWidth = 15f
        pointPaint.strokeCap = Paint.Cap.ROUND

        arcPaint = Paint()
        arcPaint.style = Paint.Style.STROKE
        var endColor = ContextCompat.getColor(context, R.color.transparent)
        var startColor = ContextCompat.getColor(context, R.color.white)
        arcPaint.shader = SweepGradient(width/2F,height/2F,endColor,startColor)

        for (i in 1..linearArc){
            arcS.add(FireWorksCircle())
        }
        postDelayed(runnable,17)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        cannel = true
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if(needReset){
            needReset = false
            init()
        }
        Log.d(TAG,"x:${point.x}   y${point.y}")
//        canvas?.drawPoint(point.x,point.y,pointPaint)
        for (fireWorksCircle in arcS){
            canvas?.drawArc(fireWorksCircle.rectF,angle,fireWorksCircle.arcLength,false,arcPaint)
            fireWorksCircle.next()
        }
    }

    fun calculatePoint():PointF{
        point.y = (height/2+radius * Math.sin(angle.toDouble())).toFloat()
        point.x = (width/2+radius * Math.cos(angle.toDouble())).toFloat()
        return point
    }

    fun nextState(){
        angle = (angle + speed)% 360
        for (fireWorksCircle in arcS){
            fireWorksCircle.next()
        }
//        calculatePoint()
    }

    /**
     * 圆环效果
     * 每帧更新一次
     * */
    inner class FireWorksCircle{
        /**
         * 弧长
         * */
        var arcLength = 345F

        /**
         * 半径最大偏移
         * */
        var dr = 15

        /**
         * 半径最大偏移
         * */
        var dArc = 8

        /**
         * 实际绘制的圆半径
         * */
        var realRadius = 0f

        var rectF :RectF

        init {
            rectF = RectF()
            next()
        }
        fun next(){
            realRadius = radius + random.nextFloat() * dr - 2*dr
            rectF.set(centerPoint.x-realRadius,centerPoint.y-realRadius,centerPoint.x+realRadius,centerPoint.y+realRadius)
            arcLength = this@MiSportView.arcLength + random.nextFloat() * dArc
        }
    }

    inner class AnimationThread :Thread(){
        override fun run() {
            super.run()
        }
    }
}