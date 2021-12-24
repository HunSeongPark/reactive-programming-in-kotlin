package com.hunseong.rxpginkotlin

import io.reactivex.Observable

fun main() {
    val observable = Observable.just(1, 2, 3, 4)

    observable
        .map {
            "$it to String!"
        }
        .subscribe {
            println("onNext - $it")
        }
}


//onNext - 1 to String!
//onNext - 2 to String!
//onNext - 3 to String!
//onNext - 4 to String!