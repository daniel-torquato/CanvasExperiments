package com.example.canvasexperiments.presentation

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import java.lang.Float.min

class SimpleBox(context: Context, attrs: AttributeSet): View(context, attrs) {

    var ballHeightOffset: Float = 0f
        set(param) {
            field = param
            invalidate()
        }

    companion object {
        const val ballRadiusFactor = 0.3f
    }

    private val borderPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.RED
        style = Paint.Style.STROKE
        strokeWidth = 20f
    }

    private val ballPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLUE
        style = Paint.Style.FILL
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val centerX = (width.toFloat()) / 2f
        val centerY = (height.toFloat()) / 2f
        val radius = ballRadiusFactor * min(centerX, centerY)

        canvas?.drawCircle(centerX , centerY + ballHeightOffset, radius, ballPaint)
        canvas?.drawRect(0f, 0f, width.toFloat(), height.toFloat(), borderPaint)
    }
}