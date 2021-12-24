package com.hunseong.rxpginkotlin

import io.reactivex.Observable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main() {
    val observable = Observable.just(1,1,2,2,3,2,4)

    observable
        .distinct()
        .subscribe {
            println("distinct - $it")
        }

    observable
        .distinctUntilChanged()
        .subscribe {
            println("distinctUntilChanged - $it")
        }
}

//distinct - 1
//distinct - 2
//distinct - 3
//distinct - 4
//distinctUntilChanged - 1
//distinctUntilChanged - 2
//distinctUntilChanged - 3
//distinctUntilChanged - 2
//distinctUntilChanged - 4