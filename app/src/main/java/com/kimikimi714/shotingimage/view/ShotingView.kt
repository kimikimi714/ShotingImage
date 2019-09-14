package com.kimikimi714.shotingimage.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.view.MotionEvent
import android.view.View
import androidx.core.content.ContextCompat
import com.kimikimi714.shotingimage.R
import com.kimikimi714.shotingimage.animation.VerticalAnimation

class ShotingView(context: Context) : View(context) {
    /**
     * 一度でもタッチイベントが発生していたらtrue
     */
    private var firstTouch = false

    private var bullet = Bullet(0f, 0f)
    private var yval = 0
    val position: Int
        get() = yval
    private val aircraft = Aircraft(0f, 0f)

    /**
     * 描画・再描画時に呼ばれる
     */
    override fun onDraw(canvas: Canvas) {
        if (firstTouch) {
            bullet.shot()
            canvas.drawOval(bullet, bullet.paint)
            canvas.drawRect(aircraft, aircraft.paint)
        }
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        if (!firstTouch) {
            firstTouch = true
        }

        aircraft.moveTo(event.x, event.y)
        bullet = Bullet(event.x, event.y)
        invalidate()
        // 最終position
        val endPosition = - 200
        val animation = VerticalAnimation(this, endPosition)
        // アニメーションの起動期間を設定
        animation.setDuration(5000)
        this.startAnimation(animation)
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
        private val rectHalfWidth = 100f
        val paint = Paint()

        constructor(left: Float, top: Float) : this() {
            this.topAbs = top

            this.left = left - rectHalfWidth
            this.top = top - rectHalfWidth
            this.right = left + rectHalfWidth
            this.bottom = top + rectHalfWidth

            this.paint.color = ContextCompat.getColor(context, R.color.colorAccent)
        }

        fun shot() {
            top =  topAbs - rectHalfWidth - yval
            bottom = topAbs + rectHalfWidth - yval
        }
    }

    inner class Aircraft() : RectF() {
        val paint = Paint()
        private val rectHalfWidth = 100f

        constructor(left: Float, top: Float) : this() {
            this.left = left - rectHalfWidth
            this.top = top - rectHalfWidth
            this.right = left + rectHalfWidth
            this.bottom = top + rectHalfWidth
            this.paint.color = ContextCompat.getColor(context, R.color.colorPrimaryDark)
        }

        fun moveTo(x: Float, y: Float) {
            left = x - rectHalfWidth
            top = y - rectHalfWidth
            right = x + rectHalfWidth
            bottom = y + rectHalfWidth
        }
    }
}