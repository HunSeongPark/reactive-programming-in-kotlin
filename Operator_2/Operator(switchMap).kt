package com.hunseong.rxpginkotlin

import io.reactivex.Observable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main() {
    val observable = Observable.range(1, 10)

    observable
        .switchMap {
            return@switchMap Observable.just(it).delay(100, TimeUnit.MILLISECONDS)
        }
        .subscribe {
            println("onNext = $it")
        }
    runBlocking {
        delay(1000)
    }
}

//onNext = 10