package com.hunseong.rxpginkotlin

import io.reactivex.Observable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main() {
    val observable = Observable.interval(100, TimeUnit.MILLISECONDS)
    observable
        .skipWhile {
            it.toInt() < 5
        }
        .subscribe {
            println("onNext = $it")
        }

    runBlocking { delay(1000) }
}

//onNext = 5
//onNext = 6
//onNext = 7
//onNext = 8
//onNext = 9