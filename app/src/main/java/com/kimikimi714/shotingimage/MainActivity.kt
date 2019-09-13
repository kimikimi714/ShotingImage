package com.kimikimi714.shotingimage

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

import com.kimikimi714.shotingimage.animation.FallAnimation
import com.kimikimi714.shotingimage.view.FallViewInterface

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // viewの設定
        val testView = TestView(this)
        setContentView(testView)

        // 最終position
        val endPosition = 1000
        val testAnimation = FallAnimation(testView, endPosition)
        // アニメーションの起動期間を設定
        testAnimation.setDuration(5000)

        testView.startAnimation(testAnimation)
    }

    inner class TestView(context: Context) : View(context), FallViewInterface {
        private var paint = Paint()

        private var leftAbsPos = 400f
        private var topAbsPos = 100f
        private var recWidth = 200f

        override var yval = 0
        override val position
            get() = yval

        override fun onDraw(canvas: Canvas) {
            // 矩形の色を設定
            paint.setColor(resources.getColor(R.color.colorAccent))
            // (left, top, right, bottom) 左上(400, 100)を起点に幅200の矩形を書いてyvalずつ下に向かって移動
            canvas.drawRect(
                leftAbsPos,
                topAbsPos + yval,
                leftAbsPos + recWidth,
                topAbsPos + recWidth + yval,
                paint
            )
        }

        override fun setPosition(pos: Int) {
            yval = pos
        }
    }
}
