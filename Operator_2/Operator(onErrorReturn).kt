package com.hunseong.rxpginkotlin

import io.reactivex.Observable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main() {
    val observable = Observable.range(1, 10)
    observable
        .map { it / 0 }
        .onErrorReturn { 999 }
        .subscribe {
            println("onNext = $it")
        }
}

//onNext = 999