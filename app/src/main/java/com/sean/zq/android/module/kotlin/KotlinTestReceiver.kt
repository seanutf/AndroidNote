package com.sean.zq.android.module.kotlin

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class KotlinTestReceiver : BroadcastReceiver() {

    companion object {
        public val action: String = "this is a broadcast action"
    }
    override fun onReceive(context: Context, intent: Intent) {
        val intentName = intent.action

        if (intentName == action) {
            val s = intent.extras.getString("data")
            context.toast("Broadcast received!! {$s}")
        }
    }

    private fun Context.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, duration).show()
    }
}
