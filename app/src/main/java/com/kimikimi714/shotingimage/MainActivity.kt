package com.kimikimi714.shotingimage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kimikimi714.shotingimage.animation.VerticalAnimation
import com.kimikimi714.shotingimage.view.ShotingView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // viewの設定
        val view = ShotingView(this)
        setContentView(view)
    }
}
