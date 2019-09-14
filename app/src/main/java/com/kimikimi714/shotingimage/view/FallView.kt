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
    private var rect = FallSquare(Random.nextFloat() * 800, Random.nextFloat() * 500)
    private var yval = 0
    val position: Int
        get() = yval

    /**
     * 描画・再描画時に呼ばれる
     */
    override fun onDraw(canvas: Canvas) {
        rect.fall()
        canvas.drawRect(rect, accentPaint())
    }

    /**
     * 高さを設定する
     */
    fun setPosition(pos: Int) {
        yval = pos
    }

    /**
     * アクセントカラーで塗りつぶす
     */
    private fun accentPaint(): Paint {
        val accent = Paint()
        accent.color = ContextCompat.getColor(context, R.color.colorAccent)
        return accent
    }

    inner class FallSquare() : RectF() {
        private val rectWidth = 200f

        constructor(left: Float, top: Float) : this() {
            this.left = left
            this.top = top
            this.right = left + rectWidth
            this.bottom = top + rectWidth
        }

        fun fall() {
            rect.top = rect.top + yval
            rect.bottom = rect.top + rectWidth
        }
    }
}
