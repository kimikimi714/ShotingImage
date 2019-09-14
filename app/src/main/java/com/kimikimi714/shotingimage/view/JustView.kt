package com.kimikimi714.shotingimage.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.view.MotionEvent
import android.view.View
import androidx.core.content.ContextCompat

import com.kimikimi714.shotingimage.R

class JustView(context: Context) : View(context) {
    /**
     * 一度でもタッチイベントが発生していたらtrue
     */
    private var firstTouch = false
    private val oval = Square(0f, 0f)

    /**
     * 描画・再描画時に呼ばれる
     */
    override fun onDraw(canvas: Canvas) {
        if (firstTouch) {
            canvas.drawOval(oval, paintDark())
        }
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        if (!firstTouch) {
            firstTouch = true
        }

        oval.moveTo(event.x, event.y)
        invalidate()
        return super.dispatchTouchEvent(event)
    }

    /**
     * アクセントカラーで塗りつぶす
     */
    private fun paintDark(): Paint {
        val accent = Paint()
        accent.color = ContextCompat.getColor(context, R.color.colorPrimaryDark)
        return accent
    }

    inner class Square() : RectF() {
        private val rectHalfWidth = 100f

        constructor(left: Float, top: Float) : this() {
            this.left = left - rectHalfWidth
            this.top = top - rectHalfWidth
            this.right = left + rectHalfWidth
            this.bottom = top + rectHalfWidth
        }

        fun moveTo(x: Float, y: Float) {
            left = x - rectHalfWidth
            top = y - rectHalfWidth
            right = x + rectHalfWidth
            bottom = y + rectHalfWidth
        }
    }
}
