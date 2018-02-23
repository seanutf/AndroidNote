package com.sean.zq.android.module.kotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.sean.note.android.R
import kotlinx.android.synthetic.main.activity_kotlin_test_broadcast.*

class KotlinTestBroadcastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_test_broadcast)
        button_broadcast.setOnClickListener({
            button_broadcast.isEnabled = false
            val intent = Intent(KotlinTestReceiver.action)
            intent.putExtra("data", "Broadcast Message!!")
            sendBroadcast(intent)
        })
    }
}
