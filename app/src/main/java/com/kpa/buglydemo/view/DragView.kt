package com.kpa.buglydemo.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 *author: mr.kong
 *Date:2018/10/31
 *description:
 *project name:BuglyDemo
 **/
class DragView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private lateinit var mPaint: Paint

    init {
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mPaint.color = Color.YELLOW
        mPaint.style = Paint.Style.FILL
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawRect(100F, 100F, 400F, 400F, mPaint)
    }
}