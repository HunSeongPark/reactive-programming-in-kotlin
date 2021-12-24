package com.hunseong.rxpginkotlin

import io.reactivex.Observable

fun main() {
    val observable = Observable.just(0,1,2,3)

    observable
        .filter { it > 5 }
        .switchIfEmpty(Observable.range(100,10))
        .subscribe {
            println("onNext - $it")
        }
}

//onNext - 100
//onNext - 101
//onNext - 102
//onNext - 103
//onNext - 104
//onNext - 105
//onNext - 106
//onNext - 107
//onNext - 108
//onNext - 109