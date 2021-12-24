package com.hunseong.rxpginkotlin

import io.reactivex.Observable

fun main() {
    val observable = Observable.just(1, 2, 3, 4)

    observable
        .ignoreElements()
        .subscribe {
            println("onComplete!")
        }
}

//onComplete!