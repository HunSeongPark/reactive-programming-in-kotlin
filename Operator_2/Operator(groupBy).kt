package com.hunseong.rxpginkotlin

import io.reactivex.Observable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main() {
    val observable = Observable.range(1, 10)

    observable
        .groupBy {
            it > 5
        }
        .subscribe {
            println("key: ${it.key}")
            // groupBy의 it = Group의 각 Observable
            // 각 Observable을 subscribe 처리
            it.subscribe { value ->
                println("onNext = $value")
            }
        }
}

//key: false
//onNext = 1
//onNext = 2
//onNext = 3
//onNext = 4
//onNext = 5
//key: true
//onNext = 6
//onNext = 7
//onNext = 8
//onNext = 9
//onNext = 10
