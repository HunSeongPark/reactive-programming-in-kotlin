package com.hunseong.rxpginkotlin

import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    // 백프레셔 전략으로 배출되는 동안 subscriber가 준비되지 않으면 모두 drop함
    val flowable = Flowable.range(1, 1000).onBackpressureDrop()
        .observeOn(Schedulers.io())
    flowable.subscribe {
        println("sub1 - $it")
        runBlocking { delay(100) }
    }

    runBlocking { delay(100000) }


}

// sub1 - 1 ~ 128 (나머지는 백프레셔 전략에 의해 모두 drop 됨)