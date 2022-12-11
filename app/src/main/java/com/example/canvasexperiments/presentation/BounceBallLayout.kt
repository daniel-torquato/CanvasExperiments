package com.example.canvasexperiments.presentation

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import androidx.constraintlayout.widget.ConstraintLayout

class BounceBallLayout(context: Context, private val attrs: AttributeSet): ConstraintLayout(context, attrs) {

    private val boxWidth = 300
    private val boxHeight = 300
    private val midDistance = 100

    private val topBox = SimpleBox(context, attrs)
    private val bottomBox = SimpleBox(context, attrs)

    private val choreograph = DoubleBoxChoreograph(topBox, bottomBox, midDistance.toFloat())

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)

        Log.e("MyTag", "> $boxWidth")

        topBox.layout(width/2 - boxWidth/2, height/2 - midDistance/2  - boxHeight , width/2 + boxWidth/2, height/2 - midDistance/2)
        this.addView(topBox, layoutParams)

        bottomBox.layout(width/2 - boxWidth/2, height/2 + midDistance/2, width/2 + boxWidth/2, height/2 + midDistance/2 + boxHeight)
        this.addView(bottomBox, layoutParams)
    }
}