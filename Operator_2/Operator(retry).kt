package com.hunseong.rxpginkotlin

import io.reactivex.Observable

fun main() {
    val observable = Observable.range(1, 10)
    var retryCount = 0
    observable
        .map { it / (3 - it) }
        .retry { _,_ ->
            (++retryCount) < 3
        }
        .subscribe({
            println("onNext = $it")
        }, {
            println("onError = $it")
        }, {
            println("onComplete")
        })
}

//onNext = 0
//onNext = 2
//onNext = 0
//onNext = 2
//onNext = 0
//onNext = 2
//onError = java.lang.ArithmeticException: / by zero