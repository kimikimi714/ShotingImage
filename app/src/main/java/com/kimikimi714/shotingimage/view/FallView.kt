package com.kimikimi714.shotingimage.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.view.View

import com.kimikimi714.shotingimage.R

class FallView(context: Context) : View(context) {
    private var paint = Paint()

    private var leftAbsPos = 400f
    private var topAbsPos = 100f
    private var recWidth = 200f

    var yval = 0
    val position: Int
        get() = yval

    override fun onDraw(canvas: Canvas) {
        // 矩形の色を設定
        paint.color = resources.getColor(R.color.colorAccent)
        // (left, top, right, bottom) 左上(400, 100)を起点に幅200の矩形を書いてyvalずつ下に向かって移動
        val rect = RectF(
            leftAbsPos,
            topAbsPos + yval,
            leftAbsPos + recWidth,
            topAbsPos + recWidth + yval
        )
        canvas.drawRect(rect, paint)
    }

    fun setPosition(pos: Int) {
        yval = pos
    }
}
