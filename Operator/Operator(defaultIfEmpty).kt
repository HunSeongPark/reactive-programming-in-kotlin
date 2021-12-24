package com.hunseong.rxpginkotlin

import io.reactivex.Observable

fun main() {
    val observable = Observable.just(1,2,3,4)

    // filter를 통해 5 보다 큰 값만 발행하도록 하였으므로 빈 observable 반환됨
    observable
        .filter { it > 5 }
        .defaultIfEmpty(-1)
        .subscribe {
            println("onNext - $it")
        }
}

//onNext - -1