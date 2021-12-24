package com.hunseong.rxpginkotlin

import io.reactivex.Observable

fun main() {
    val observable = Observable.range(1, 10)

    observable
        .count()
        .subscribe { count ->
            println("count = $count")
        }
}

//count = 10