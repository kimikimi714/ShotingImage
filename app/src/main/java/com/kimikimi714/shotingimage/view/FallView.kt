package com.kimikimi714.shotingimage.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.view.View
import androidx.core.content.ContextCompat

import com.kimikimi714.shotingimage.R
import kotlin.random.Random

class FallView(context: Context) : View(context) {
    private var yval = 0
    val position: Int
        get() = yval

    override fun onDraw(canvas: Canvas) {
        val left = Random.nextFloat() * 800
        val top = Random.nextFloat() * 500
        canvas.drawRect(createRecf(left, top), accentPaint())
    }

    fun setPosition(pos: Int) {
        yval = pos
    }

    private fun accentPaint(): Paint {
        val accent = Paint()
        accent.color = ContextCompat.getColor(context, R.color.colorAccent)
        return accent
    }

    private fun createRecf(left: Float, top: Float): RectF {
        val recWidth = 200f
        return RectF(
            left,
            top + yval,
            left + recWidth,
            top + recWidth + yval
        )
    }
}
