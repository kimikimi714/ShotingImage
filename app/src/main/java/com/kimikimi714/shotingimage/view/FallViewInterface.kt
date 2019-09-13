package com.kimikimi714.shotingimage.view

interface FallViewInterface {
    var yval: Int
    val position: Int
        get() = yval

    fun setPosition(pos: Int)
}