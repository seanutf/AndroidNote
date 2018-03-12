package com.sean.zq.android.module.kotlin

import android.app.IntentService
import android.content.Intent
import android.content.Context
import io.reactivex.plugins.RxJavaPlugins
import java.io.InterruptedIOException
import java.util.logging.Logger

/**
 * An [IntentService] subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 */
class KotlinIntentService : IntentService("KotlinIntentService") {

    override fun onHandleIntent(intent: Intent?) {
        if (intent != null) {
            val action = intent.action
            if (ACTION_PRINT == action) {
                val logStr = intent.getStringExtra(STR_PRINT)
                if(!logStr.isNullOrBlank()){
                    log.info("Message is : ${logStr}")
                }
            } else if (ACTION_BAZ == action) {
                val param1 = intent.getStringExtra(STR_PRINT)
                val param2 = intent.getStringExtra(EXTRA_PARAM2)
                handleActionBaz(param1, param2)
            }
        }
    }
    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private fun handleActionBaz(param1: String, param2: String) {
        // TODO: Handle action Baz
        throw UnsupportedOperationException("Not yet implemented")
    }

    companion object {
        val log = Logger.getLogger(KotlinIntentService.javaClass.name)
        private val ACTION_PRINT = "com.sean.zq.android.module.kotlin.action.PRINT"
        private val ACTION_BAZ = "com.sean.zq.android.module.kotlin.action.BAZ"

        val logStr = ACTION_BAZ + "dff"
        init {
            RxJavaPlugins.setErrorHandler { throwable ->
                //is关键字等同于Java中的instanceof
                if (throwable is InterruptedIOException) {
                    log.info("Io interrupted")
                }
            }
        }

        private val STR_PRINT = "com.sean.zq.android.module.kotlin.extra.STR_PRINT"
        private val EXTRA_PARAM2 = "com.sean.zq.android.module.kotlin.extra.PARAM2"

        /**
         * Starts this service to perform action Foo with the given parameters. If
         * the service is already performing a task this action will be queued.
         *
         * @see IntentService
         */
        fun startActionPrintLog(context: Context, logStr: String) {
            val intent = Intent(context, KotlinIntentService::class.java)
            intent.action = ACTION_PRINT
            intent.putExtra(STR_PRINT, logStr)
            context.startService(intent)
        }
    }
}
