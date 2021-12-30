package com.hunseong.rxpginkotlin

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {

    val observable = Observable.create<String> {
        it.onNext("onNext - ${Thread.currentThread().name}")
    }

    observable
        .map {
            println("map - ${Thread.currentThread().name}")
            return@map it
        }
        .subscribeOn(Schedulers.computation())
        .subscribe {
            println(it)
        }

    runBlocking {
        delay(1000)
    }
}

//map - RxComputationThreadPool-1
//onNext - RxComputationThreadPool-1