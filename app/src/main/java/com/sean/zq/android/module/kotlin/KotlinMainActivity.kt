package com.sean.zq.android.module.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.widget.LinearLayoutManager
import com.sean.note.android.BuildConfig
import com.sean.note.android.R
import com.sean.zq.android.module.data.serialize.meta.AddrData
import kotlinx.android.synthetic.main.activity_kotlin_main.*
import java.util.logging.Logger

class KotlinMainActivity : AppCompatActivity() {

    /**
     * companion object 用于创建静态对象，包括：变量、方法、内部类
     * 且每一个类中只能有一个
     * */
    //静态变量、方法
//    companion object {
//        val log = Logger.getLogger(KotlinMainActivity.javaClass.name)
//        fun getCurrentVersion(): String {
//            return BuildConfig.VERSION_NAME
//        }
//    }
    //静态内部类
    /**
     * YoungPeople 我的理解是形式内部类名（自定义）
     * create   创建内部类时调用的方法（自定义）
     * AddrData  是实际的内部类名
     * 调用时，有以下3种调用：
     * 1
     *  var instance1 = KotlinMainActivity.create()
     *  2
     *   var instance2 = YoungPeople.create()
     *  3
     *  val factory = KotlinMainActivity.YoungPeople
        var instance3 = factory.create()
     4
        var instance4 = create()
     * */

    companion object YoungPeople{
        fun create(): AddrData = AddrData()
        val log = Logger.getLogger(KotlinMainActivity.javaClass.name)
        fun getCurrentVersion(): String {
            return BuildConfig.VERSION_NAME
        }
    }
    private val demoList = listOf("BroadcastReceiver", "IntentService")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_main)
        var instance = YoungPeople.create()
        // 也可以使用下面的方法来调用
        // 由于Factory定义后不可修改，故使用val变量来存放
        val factory = KotlinMainActivity.YoungPeople
        var instance1 = create()
        var aa = getCurrentVersion()
        kotlin_demo_list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        kotlin_demo_list.adapter = KotlinMainListAdapter(demoList, this)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onRestart() {
        super.onRestart()
    }
}
