package com.hunseong.rxpginkotlin

import io.reactivex.Observable

fun main() {
    val observable = Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    observable
        .filter { it%2 == 0 }
        .subscribe {
            println("result - $it")
        }
}

//result - 2
//result - 4
//result - 6
//result - 8
//result - 10