package com.example.canvasexperiments.presentation

import android.animation.ValueAnimator
import android.animation.ValueAnimator.ofInt
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.animation.LinearInterpolator
import androidx.constraintlayout.widget.ConstraintLayout
import java.lang.Math.abs

class BounceBallLayout(context: Context, private val attrs: AttributeSet): ConstraintLayout(context, attrs) {

    private val boxWidth = 500
    private val boxHeight = 300
    private var midDistance = 0

    private val topBox = SimpleBox(context, attrs)
    private val bottomBox = SimpleBox(context, attrs)

    private val choreograph = DoubleBoxChoreograph(topBox, bottomBox)

    val animator = ofInt(0, 300).apply {
        duration = 5100
        interpolator = LinearInterpolator()
        repeatCount = ValueAnimator.INFINITE
        addUpdateListener {
            midDistance = 300 - kotlin.math.abs(2 * (it.animatedValue as Int) - 300)
            choreograph.midDistance = midDistance
            topBox.layout(width/2 - boxWidth/2, height/2 - midDistance/2  - boxHeight , width/2 + boxWidth/2, height/2 - midDistance/2)
            bottomBox.layout(width/2 - boxWidth/2, height/2 + midDistance/2, width/2 + boxWidth/2, height/2 + midDistance/2 + boxHeight)
        }
    }

    init {
        animator.start()
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)

        Log.e("MyTag", "> $boxWidth")

        topBox.layout(width/2 - boxWidth/2, height/2 - midDistance/2  - boxHeight , width/2 + boxWidth/2, height/2 - midDistance/2)
        bottomBox.layout(width/2 - boxWidth/2, height/2 + midDistance/2, width/2 + boxWidth/2, height/2 + midDistance/2 + boxHeight)

        this.addView(topBox, layoutParams)


        this.addView(bottomBox, layoutParams)
    }
}