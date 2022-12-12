package com.example.canvasexperiments.presentation

import android.animation.ValueAnimator
import android.view.animation.LinearInterpolator

class DoubleBoxChoreograph(val topBox: SimpleBox, val bottomBox: SimpleBox) {

    var midDistance: Int = 0

    private var ballParam = 0f
        set(param) {
            ballsChoreograph(param)
            field = param
        }

    private fun ballsChoreograph(param: Float) {
        val boxHeight = topBox.height
        topBox.ballHeightOffset = param * (boxHeight + midDistance)
        bottomBox.ballHeightOffset = (param - 1f) * (boxHeight + midDistance)
    }

    private val animator: ValueAnimator = ValueAnimator.ofFloat(0f, 1f).apply {
        duration  = 2000
        interpolator = LinearInterpolator()
        repeatCount = ValueAnimator.INFINITE
        addUpdateListener {
            ballParam = 1f - kotlin.math.abs(2f * (it.animatedValue as Float) - 1f)
        }
    }

    init {
        animator.start()
    }
}