package com.sean.zq.android.utils

/**
 * Created by Sean on 2018/2/1.
 */
class TestKK {
    var name = "I'm learning Kotlin"
    var testK = TestK()
    fun ii() {
        testK.isError
    }
}

class TestK {
    var name: String = "I'm learning Kotlin2"
    var isError: Boolean = true
        get() {
            return true
        }
}