package com.example.customviewcomponentassignment.views.component

import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.withStyledAttributes
import com.example.customviewcomponentassignment.R


class RoundedCornerImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    private var borderColor = Color.DKGRAY
    private var borderWidth = 0f
    private var size = 0
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var cornerRadius = 0f

    private val path = Path()

    init {
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.CircleImageView)
        borderColor = attributes.getColor(R.styleable.CircleImageView_border_color, Color.WHITE)
        borderWidth = attributes.getDimension(R.styleable.CircleImageView_border_width, 0f)
        cornerRadius = attributes.getDimension(R.styleable.CircleImageView_cornerRadius,0f)
    }

    override fun onDraw(canvas: Canvas?) {
        val rectangle = RectF(0f, 0f, width.toFloat(), height.toFloat())

        path.addRoundRect(rectangle, cornerRadius, cornerRadius, Path.Direction.CCW)

        canvas?.clipPath(path)

        super.onDraw(canvas)

        drawRoundImage(canvas)
//        drawStroke(canvas)
    }

    fun drawStroke(canvas: Canvas?) {
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        val radius = width / 2f

        /* Border paint */
        paint.color = borderColor
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = borderWidth
        canvas?.drawCircle(width / 2f, width / 2f, radius - borderWidth / 2f, paint)
    }

    fun drawRoundImage(canvas: Canvas?) {
        var b: Bitmap = (drawable as BitmapDrawable).bitmap
        val bitmap = b.copy(Bitmap.Config.ARGB_8888, true)

        /* Scale the bitmap */
        val scaledBitmap: Bitmap
        val ratio: Float = bitmap.width.toFloat() / bitmap.height.toFloat()
        val height: Int = Math.round(width / ratio)
        scaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, false)

        /* Cutting the outer of the circle */
//        val shader: Shader
//        shader = BitmapShader(scaledBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)

        //paint.isAntiAlias = true
        //paint.shader = shader


//        paint.style = Paint.Style.FILL_AND_STROKE
//
        val radius = width / 2f
        size = width
//
//        canvas?.drawCircle(size / 2f, size / 2f, radius, paint)

        paint.color = borderColor
       paint.style = Paint.Style.STROKE
        paint.strokeWidth = borderWidth

        canvas?.drawCircle(size / 2f, size / 2f, radius - borderWidth / 2f, paint)
    }


}

