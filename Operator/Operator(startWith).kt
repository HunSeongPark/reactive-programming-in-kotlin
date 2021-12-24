package com.hunseong.rxpginkotlin

import io.reactivex.Observable

fun main() {
    val observable = Observable.just(0,1,2,3)

    observable
        .startWith(-123)
        .subscribe {
            println("onNext - $it")
        }
}

//onNext - -123
//onNext - 0
//onNext - 1
//onNext - 2
//onNext - 3