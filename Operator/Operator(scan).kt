package com.hunseong.rxpginkotlin

import io.reactivex.Observable

fun main() {
    val observable = Observable.range(1, 10)

    // prevScan : scan을 통해 이전에 변환되어 발행된 값
    // currentObs : 현재 observable에서 발행된 값
    observable
        .scan { prevScan, currentObs ->
            prevScan + currentObs
        }
        .subscribe {
            println("onNext = $it")
        }
}

//onNext = 1
//onNext = 3
//onNext = 6
//onNext = 10
//onNext = 15
//onNext = 21
//onNext = 28
//onNext = 36
//onNext = 45
//onNext = 55