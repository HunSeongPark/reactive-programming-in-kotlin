package com.hunseong.rxpginkotlin

import io.reactivex.Observable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main() {
    val observable = Observable.range(1, 10)
    val observable2 = Observable.interval(100, TimeUnit.MILLISECONDS)
    observable
        .skip(5)
        .subscribe {
            println("skip(count) = $it")
        }

    observable2
        .skip(300, TimeUnit.MILLISECONDS)
        .subscribe {
            println("skip(time) = $it")
        }

    runBlocking { delay(1000) }
}

//skip(count) = 6
//skip(count) = 7
//skip(count) = 8
//skip(count) = 9
//skip(count) = 10
//skip(time) = 3
//skip(time) = 4
//skip(time) = 5
//skip(time) = 6
//skip(time) = 7
//skip(time) = 8
//skip(time) = 9