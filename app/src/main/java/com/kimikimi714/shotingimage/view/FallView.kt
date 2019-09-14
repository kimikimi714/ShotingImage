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
    private var left = 0f
    private var top = 0f
    private var yval = 0
    val position: Int
        get() = yval

    /**
     * 描画・再描画時に呼ばれる
     */
    override fun onDraw(canvas: Canvas) {
        canvas.drawRect(createRecf(left, top), accentPaint())
    }

    /**
     * ビューのウインドウへの割当時によばれる
     */
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        left = Random.nextFloat() * 800
        top = Random.nextFloat() * 500
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

    /**
     * 矩形を作る
     */
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
