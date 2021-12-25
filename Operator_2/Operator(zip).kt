package com.hunseong.rxpginkotlin

import io.reactivex.Observable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main() {
    val observable = Observable.interval(100, TimeUnit.MILLISECONDS)
    val observable2 = Observable.interval(300, TimeUnit.MILLISECONDS)
    val observable3 = Observable.interval(500, TimeUnit.MILLISECONDS)

    Observable
        .zip(observable, observable2, observable3) { a, b, c ->
        "A: $a / B: $b / C: $c" }
        .subscribe {
            println(it)
        }

    runBlocking {
        delay(3000)
    }
}

//A: 0 / B: 0 / C: 0
//A: 1 / B: 1 / C: 1
//A: 2 / B: 2 / C: 2
//A: 3 / B: 3 / C: 3
//A: 4 / B: 4 / C: 4
//A: 5 / B: 5 / C: 5
