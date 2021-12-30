package com.hunseong.rxpginkotlin

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    val observable = Observable.range(1, 3)
    observable
        .subscribeOn(Schedulers.trampoline())
        .subscribe {
            runBlocking { delay(100) }
            println("onNext(trampoline) = $it")
        }

    for(i in 0..3) {
        runBlocking { delay(100) }
        println("main Thread = $i")
    }

    runBlocking {
        delay(3000)
    }
}

//onNext(trampoline) = 1
//onNext(trampoline) = 2
//onNext(trampoline) = 3
//main Thread = 0
//main Thread = 1
//main Thread = 2
//main Thread = 3