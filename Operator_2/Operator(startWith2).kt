package com.hunseong.rxpginkotlin

import io.reactivex.Observable

fun main() {
    val observable = Observable.range(11, 10)
    val observable2 = Observable.range(1, 10)
    observable
        .startWith(observable2)
        .subscribe { result ->
            println("onNext = $result")
        }
}

//onNext = 1
//onNext = 2
//onNext = 3
//onNext = 4
//onNext = 5
//onNext = 6
//onNext = 7
//onNext = 8
//onNext = 9
//onNext = 10
//onNext = 11
//onNext = 12
//onNext = 13
//onNext = 14
//onNext = 15
//onNext = 16
//onNext = 17
//onNext = 18
//onNext = 19
//onNext = 20
