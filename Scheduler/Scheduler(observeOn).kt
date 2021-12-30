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
        .observeOn(Schedulers.io())
        .map {
            println("map - ${Thread.currentThread().name}")
            return@map it
        }
        .observeOn(Schedulers.single())
        .map {
            println("map2 - ${Thread.currentThread().name}")
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

//map - RxCachedThreadScheduler-1
//map2 - RxSingleScheduler-1
//onNext - RxComputationThreadPool-1