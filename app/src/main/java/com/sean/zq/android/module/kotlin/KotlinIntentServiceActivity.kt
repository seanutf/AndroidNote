package com.sean.zq.android.module.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.sean.note.android.R

class KotlinIntentServiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_intent_service)
        KotlinIntentService.startActionPrintLog(this, "Hello Intent service used for handling asynchronous task")
    }
}
