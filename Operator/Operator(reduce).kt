package com.hunseong.rxpginkotlin

import io.reactivex.Observable

fun main() {
    val observable = Observable.range(1, 10)

    // prevReduce : prevScan을 통해 현재까지 누적된 값
    // currentObs : 현재 observable에서 발행된 값
    observable
        .reduce { prevReduce, currentObs ->
            prevReduce + currentObs
        }
        .subscribe { result ->
            println("onNext = $result")
        }
}

//onNext = 55