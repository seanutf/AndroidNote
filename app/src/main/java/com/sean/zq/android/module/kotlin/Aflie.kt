package com.sean.zq.android.module.kotlin

import java.math.BigDecimal

/**
 * Created by Sean on 2018/4/19.
 */

fun higherOreder(f: (Int, Int) -> Int, g: () -> Unit){
    val float = 10F;
    val bd = 10.BD
}

private val Int.BD: BigDecimal
    get() {
        return BigDecimal(this)
    }

fun main(args :Array<String>){

    //throw Exception("Blaah")
    //print("Bye")
    doSomething()
    print("Hello!")
}
fun doSomething(): Nothing{
    throw Exception("Nothing")
}