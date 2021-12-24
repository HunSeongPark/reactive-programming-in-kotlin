package com.hunseong.rxpginkotlin

import io.reactivex.Observable

fun main() {
    val observable = Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    observable
        .first(-1)
        .subscribe { result ->
            println("first - $result")
        }

    observable
        .last(-1)
        .subscribe { result ->
            println("last - $result")
        }
}

//first - 1
//last - 10