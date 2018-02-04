package com.sean.zq.android.utils

import android.graphics.Color

/**
 * Created by Sean on 2018/1/29.
 */
fun mix(c1:Color, c2:Color) =
        when (setOf(c1,c2)){
            setOf(Color.RED, Color.YELLOW) -> Color.YELLOW
            setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
            setOf(Color.BLUE, Color.RED) -> Color.BLACK
        else -> throw Exception("Dirty Color")
        }

val set = hashSetOf(1,5,7)

val list = arrayListOf(1, 7, 8, 9, 10)
