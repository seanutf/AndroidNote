package com.sean.zq.android.module.kotlin

import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import com.sean.note.android.R

/**
 * Created by sean on 2017/11/17.
 */
class RoundedActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_rounded)
        val img = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
        val round  = RoundedBitmapDrawableFactory.create(resources, img)
                // Radius Rounded
        round.cornerRadius = 25f
        //((ImageView)findViewById(R.id.imageView)).setImageDrawable(round)
    }
}