package com.hunseong.rxpginkotlin

import io.reactivex.Observable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main() {
    val observable = Observable.range(1, 10)
    val observable2 = Observable.interval(100, TimeUnit.MILLISECONDS)
    observable
        .skipLast(5)
        .subscribe {
            println("skip(count) = $it")
        }

    observable2
        .skipLast(300, TimeUnit.MILLISECONDS)
        .subscribe {
            println("skip(time) = $it")
        }

    runBlocking { delay(1000) }
}

//skip(count) = 1
//skip(count) = 2
//skip(count) = 3
//skip(count) = 4
//skip(count) = 5
//skip(time) = 0
//skip(time) = 1
//skip(time) = 2
//skip(time) = 3
//skip(time) = 4
//skip(time) = 5
//skip(time) = 6