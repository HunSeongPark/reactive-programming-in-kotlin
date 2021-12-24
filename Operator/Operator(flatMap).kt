package com.hunseong.rxpginkotlin

import io.reactivex.Observable

fun main() {
    val observable = Observable.just(1, 4, 7, 10)

    // flatMap을 통해 각 아이템(1, 4, 7, 10)에 대한 새로운 observable return
    // 1에 대한 새로운 observable은 1,2,3을 발행
    // 4에 대한 새로운 observable은 4,5,6을 발행
    // ...
    observable
        .flatMap { value ->
            Observable.create<Int> {
                it.onNext(value)
                it.onNext(value+1)
                it.onNext(value+2)
                it.onComplete()
            }
        }
        .subscribe ({
            println("onNext - $it")
        }, {
            println("onError!")
        }, {
            println("onComplete!")
        })
}

//onNext - 1
//onNext - 2
//onNext - 3
//onNext - 4
//onNext - 5
//onNext - 6
//onNext - 7
//onNext - 8
//onNext - 9
//onNext - 10
//onNext - 11
//onNext - 12
//onComplete!