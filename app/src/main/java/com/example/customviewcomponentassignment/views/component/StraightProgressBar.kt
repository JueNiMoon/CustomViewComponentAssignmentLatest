package com.example.customviewcomponentassignment.views.component

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.icu.math.BigDecimal
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.core.content.withStyledAttributes
import com.example.customviewcomponentassignment.R
import kotlin.math.roundToInt

class StraightProgressBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint()
    private val progressPaint = Paint()

    private var progresss = 0
    var colorfill = Color.GRAY

    init {
        context.withStyledAttributes(attrs, R.styleable.StraightProgressView) {
            progresss = getInteger(R.styleable.StraightProgressView_strProgress, 0)
            colorfill = getColor(R.styleable.StraightProgressView_color, Color.GRAY)
        }
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // draw progress bar
        paint.apply {
            paint.strokeWidth = 20f
            paint.color = Color.GRAY
        }

        canvas?.drawLine(0f, 0f, width.toFloat(), 0f, paint)

        // draw progress status
        progressPaint.apply {
            progressPaint.strokeWidth = 20f
            progressPaint.style = Paint.Style.FILL
            progressPaint.color = colorfill
        }
        canvas?.drawLine(0f, 0f, BigDecimal(progresss).toFloat(), 0f, progressPaint)
    }
}
