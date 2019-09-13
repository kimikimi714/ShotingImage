package com.kimikimi714.shotingimage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.kimikimi714.shotingimage.animation.FallAnimation
import com.kimikimi714.shotingimage.view.FallView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // viewの設定
        val mainView = FallView(this)
        setContentView(mainView)

        // 最終position
        val endPosition = 1000
        val mainAnimation = FallAnimation(mainView, endPosition)
        // アニメーションの起動期間を設定
        mainAnimation.setDuration(5000)

        mainView.startAnimation(mainAnimation)
    }
}
