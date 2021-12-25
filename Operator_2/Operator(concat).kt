package com.hunseong.rxpginkotlin

import io.reactivex.Observable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main() {
    val observable = Observable.interval(300, TimeUnit.MILLISECONDS)
        .map {
            "ob1 : $it"
        }.take(2)
    val observable2 = Observable.interval(500, TimeUnit.MILLISECONDS)
        .map {
            "ob2 : $it"
        }

    Observable
        .concat(observable, observable2)
        .subscribe {
            println(it)
        }

    runBlocking {
        delay(2000)
    }
}

//ob1 : 0
//ob1 : 1
//ob2 : 0
//ob2 : 1
