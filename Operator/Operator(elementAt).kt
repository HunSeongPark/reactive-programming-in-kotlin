package com.hunseong.rxpginkotlin

import io.reactivex.Observable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main() {
    val observable = Observable.just(0,1,2,3,4,5)

    observable
        .elementAt(1)
        .subscribe {
            println("elementAt(1) - $it")
        }

    observable
        .elementAt(4)
        .subscribe {
            println("elementAt(4) - $it")
        }
}

//elementAt(1) - 1
//elementAt(4) - 4