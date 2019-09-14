package com.kimikimi714.shotingimage.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.view.MotionEvent
import android.view.View
import androidx.core.content.ContextCompat

import com.kimikimi714.shotingimage.R
import com.kimikimi714.shotingimage.animation.VerticalAnimation

class ShotingView(context: Context) : View(context) {
    private val animation = VerticalAnimation(this, 3000)

    /**
     * 一度でもタッチイベントが発生していたらtrue
     */
    private var firstTouch = false

    private var bullet = Bullet(0f, 0f)
    private var yval = 0
    val position: Int
        get() = yval
    private val aircraft = Aircraft(0f, 0f)

    override fun onDraw(canvas: Canvas) {
        if (firstTouch) {
            bullet.shot()
            canvas.drawOval(bullet, bullet.paint)
            canvas.drawPath(aircraft, aircraft.paint)
        }
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        if (!firstTouch) {
            firstTouch = true
        }
        aircraft.reset()
        aircraft.touch(event.x, event.y)
        bullet = Bullet(event.x, event.y)
        // アニメーションの起動期間を設定
        animation.setDuration(2000)
        this.startAnimation(animation)
        invalidate()
        return super.dispatchTouchEvent(event)
    }

    /**
     * 弾道の位置を設定する
     */
    fun setPosition(pos: Int) {
        yval = pos
    }

    inner class Bullet() : RectF() {
        private var topAbs = 0f
        private val rectHalfWidth = 20f
        val paint = Paint()

        constructor(left: Float, top: Float) : this() {
            this.topAbs = top

            this.left = left - rectHalfWidth
            this.top = top
            this.right = left + rectHalfWidth
            this.bottom = top + 2 * rectHalfWidth

            this.paint.color = ContextCompat.getColor(context, R.color.colorAccent)
        }

        fun shot() {
            top = topAbs - rectHalfWidth - yval
            bottom = topAbs + rectHalfWidth - yval
        }
    }

    inner class Aircraft() : Path() {
        val paint = Paint()
        private val rectHalfWidth = 50f

        constructor(x: Float, y: Float) : this() {
            touch(x, y)
            this.paint.color = ContextCompat.getColor(context, R.color.colorPrimaryDark)
            this.paint.setStyle(Paint.Style.FILL)
        }

        fun touch(x: Float, y: Float) {
            this.moveTo(x, y - rectHalfWidth)
            this.lineTo(x - rectHalfWidth, y + 2 * rectHalfWidth)
            this.lineTo(x + rectHalfWidth, y + 2 * rectHalfWidth)
            this.close()
        }
    }
}
