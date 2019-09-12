package com.kimikimi714.shotingimage

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var yval = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val testView = TestView(this)
        setContentView(testView)

        // 最終position
        val endPosition = 1000
        val testAnimation = TestAnimation(testView, endPosition)
        // アニメーションの起動期間を設定
        testAnimation.setDuration(5000)
        testView.startAnimation(testAnimation)
    }

    inner class TestView(context: Context) : View(context) {
        internal var paint = Paint()

        val position: Int
            get() = yval

        override fun onDraw(canvas: Canvas) {
            paint.setColor(Color.argb(255, 125, 125, 125))
            // (left, top, right, bottom) 左上(400, 100)を起点に幅200の矩形
            canvas.drawRect(400f, (100 + yval).toFloat(), 600f, (300 + yval).toFloat(), paint)
        }

        fun setPositon(pos: Int) {
            yval = pos
        }
    }
}
