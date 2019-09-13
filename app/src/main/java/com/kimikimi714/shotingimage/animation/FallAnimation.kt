package com.kimikimi714.shotingimage.animation

import android.view.animation.Animation
import android.view.animation.Transformation
import com.kimikimi714.shotingimage.MainActivity

class FallAnimation internal constructor(private val testView: MainActivity.TestView, pos: Int) :
    Animation() {

    private var currentPosition = 0
    private var endPosition = 0

    init {
        currentPosition = testView.position
        endPosition = pos
    }

    override fun applyTransformation(
        interpolatedTime: Float, transformation: Transformation
    ) {
        // interpolatedTime: 0.f -> 1.0f
        val pp = ((endPosition - currentPosition) * interpolatedTime).toInt()

        // 矩形のY軸位置をセット
        testView.setPosition(pp)
        testView.requestLayout()
    }

}