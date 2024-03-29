package com.kimikimi714.shotingimage.animation

import android.view.animation.Animation
import android.view.animation.Transformation
import com.kimikimi714.shotingimage.view.ShotingView

/**
 * 垂直に等加速度運動するアニメーション
 */
class VerticalAnimation internal constructor(private val view: ShotingView, pos: Int) :
    Animation() {

    private var currentPosition = 0
    private var endPosition = 0

    init {
        currentPosition = view.position
        endPosition = pos
    }

    override fun applyTransformation(
        interpolatedTime: Float, transformation: Transformation
    ) {
        // interpolatedTime: 0.f -> 1.0f
        val pp = ((endPosition - currentPosition) * interpolatedTime).toInt()

        // 矩形のY軸位置をセット
        view.setPosition(pp)
        view.requestLayout()
    }

}