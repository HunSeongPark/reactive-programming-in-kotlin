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
        .combineLatest(observable, observable2, observable3) { a, b, c ->
        "A: $a / B: $b / C: $c" }
        .subscribe {
            println(it)
        }

    runBlocking {
        delay(1000)
    }
}

//A: 4 / B: 0 / C: 0
//A: 4 / B: 1 / C: 0
//A: 5 / B: 1 / C: 0
//A: 6 / B: 1 / C: 0
//A: 7 / B: 1 / C: 0
//A: 8 / B: 1 / C: 0
//A: 8 / B: 2 / C: 0
//A: 9 / B: 2 / C: 0
//A: 9 / B: 2 / C: 1
